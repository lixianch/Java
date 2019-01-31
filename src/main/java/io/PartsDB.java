package io;

import org.apache.commons.lang.builder.ToStringBuilder;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by lixianch on 2019/1/31.
 */
public class PartsDB {
    public static final int PNUMLEN = 20;
    public static final int DESCLEN = 30;
    public static final int QUANLEN = 4;
    public static final int COSTLEN = 4;
    public static final int RECLEN = 2 * PNUMLEN + 2 * DESCLEN + QUANLEN + COSTLEN;
    private RandomAccessFile raf;

    public PartsDB(String path) throws IOException {
        raf = new RandomAccessFile(path, "rw");
    }

    public static void main(String[] args) throws IOException {
        PartsDB partsDB = new PartsDB("data.txt");
//        partsDB.append("ware_name", "ware_desc", 4, 5);
//        partsDB.append("name", "desc", 1, 2);
        Part part = partsDB.select(2);
        System.out.println("before update: " + part);
        part.setUcost(part.getUcost() + 1);
        partsDB.update(2, part.getPartnum(), part.getDesc(), part.getQty(), part.getUcost());
        part = partsDB.select(2);
        System.out.println("after update: " + part);
        partsDB.close();
    }

    public Part select(int recNum) throws IOException{
        if(recNum < 0 || recNum > numRecs()){
            throw new IllegalArgumentException(recNum + " out of range");
        }
        raf.seek(RECLEN * (recNum - 1));
        return read();
    }
    public Integer numRecs() throws IOException {
        return (int)raf.length() / RECLEN;
    }

    private Part read() throws IOException {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < PNUMLEN; i++) {
            sb.append(raf.readChar());
        }
        String partnum = sb.toString().trim();
        sb.setLength(0);
        for (int i = 0; i < DESCLEN; i++) {
            sb.append(raf.readChar());
        }
        String desc = sb.toString().trim();
        Integer qty = raf.readInt();
        Integer ucost = raf.readInt();

        return new Part(partnum, desc, qty, ucost);
    }
    public void append(String partnum, String desc, Integer qty, Integer ucost) throws IOException {
        raf.seek(raf.length());
        write(partnum, desc, qty, ucost);
    }

    public void update(Integer recNo, String partnum, String desc, Integer qty, Integer ucost) throws IOException {
        if(recNo < 0 || recNo > numRecs()){
            throw new IllegalArgumentException(recNo + " out of range");
        }
        raf.seek((recNo - 1) * RECLEN);
        write(partnum, desc, qty, ucost);
    }
    private void write(String partnum, String desc, Integer qty, Integer ucost) throws IOException {
        writeStringField(partnum, PNUMLEN);
        writeStringField(desc, DESCLEN);
        writeIntField(qty);
        writeIntField(ucost);
    }

    private void writeStringField(String field,Integer fieldLen) throws IOException {
        StringBuffer sb = new StringBuffer(field);
        if(sb.length() > fieldLen){
            sb.setLength(fieldLen);
        }else {
            int len = fieldLen - sb.length();
            for (int i = 0; i < len; i++) {
                sb.append(" ");
            }
        }
        raf.writeChars(sb.toString());
    }
    private void writeIntField(Integer num) throws IOException {
        raf.writeInt(num);
    }
    private void close() throws IOException{
        if(raf != null){
            raf.close();
        }
    }
    public static class Part {
        private String partnum;
        private String desc;
        private Integer qty;
        private Integer ucost;

        public Part(String partnum, String desc, Integer qty, Integer ucost) {
            this.partnum = partnum;
            this.desc = desc;
            this.qty = qty;
            this.ucost = ucost;
        }

        public String getPartnum() {
            return partnum;
        }

        public void setPartnum(String partnum) {
            this.partnum = partnum;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public Integer getQty() {
            return qty;
        }

        public void setQty(Integer qty) {
            this.qty = qty;
        }

        public Integer getUcost() {
            return ucost;
        }

        public void setUcost(Integer ucost) {
            this.ucost = ucost;
        }

        @Override
        public String toString() {
            return ToStringBuilder.reflectionToString(this);
        }
    }

}
