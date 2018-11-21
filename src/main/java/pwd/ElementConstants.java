package pwd;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lixianch on 2018/9/30.
 */
public class ElementConstants {
    //常用密码组合
    public static List<String> MOST_USE = Lists.newArrayList(new String[]{"11111"});
    //常用年份
    public static List<String> YEAR = Lists.newArrayList(new String[]{"1985","1986","1987","1988","1989","1990","1991","1992","1993","1994","1995","1996","1997",
            "1998","1999","2000","2001","2002","2003","2004","2005","2006","2007","2008","2009","2010","2011","2012","2013","2014","2015",
    "2016","2017","2018"});
    //所有月份
    public static List<String> MONTH = Lists.newArrayList(new String[]{"01","02","03","04","05","06","07","08","09","10","11","12"});
    //所有日期
    public static List<String> DAY = Lists.newArrayList(new String[]{"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18",
            "19","20","21","22","23","24","25","26","27","28","29","30","31"});
    //常用姓氏全屏
    public static List<String> SURN = Lists.newArrayList(new String[]{"li","ma","wu","xu","hu","yu","he","liu","sun","gao","luo","cai","guo","zhu","wang","zhao",
            "yang","zhou","song","meng","deng","zhang","huang","liang"});
    //所有可以组成名字首字母的字母
    public static List<String> FNAME2 = Lists.newArrayList(new String[]{"b","c","d","f","g","h","j","k","l","m","n","p","q","s","t","w","x","y","z"});
    //包含名字所有字的拼音
    public static List<String> nameList = new ArrayList<>();
    static {
        String[] B_SUB = new String[]{"bo","bi","bai","bei","bao","ban","ben","bin","bang","bing","biao"};
        nameList.addAll(Lists.newArrayList(B_SUB));
        String[] C_SUB = new String[]{"ci","cai","can","cen","cun","ceng","cong"};
        nameList.addAll(Lists.newArrayList(C_SUB));
        String[] D_SUB = new String[]{"de", "di", "du", "dai", "dao", "dan", "deng", "ding", "dong"};
        nameList.addAll(Lists.newArrayList(D_SUB));
        String[] F_SUB = new String[]{"fa","fu","fei","fan","fen","feng","fang","fing"};
        nameList.addAll(Lists.newArrayList(F_SUB));
        String[] G_SUB = new String[]{"gu", "gui", "gao", "gan", "gen", "guo", "gang", "geng", "guan", "guang"};
        nameList.addAll(Lists.newArrayList(G_SUB));
        String[] H_SUB = new String[]{"hu", "hui", "hao", "han", "hen", "huo", "hang", "heng", "huan", "huang"};
        nameList.addAll(Lists.newArrayList(H_SUB));
        String[] J_SUB = new String[]{"ji", "ju", "jiu", "jie", "jin", "jun", "jue", "jing", "jia", "jiao", "jian", "jiang", "juan"};
        nameList.addAll(Lists.newArrayList(J_SUB));
        String[] K_SUB = new String[]{"kai", "kui", "kan", "kun", "kuo", "kang", "kong", "kuan", "kuang"};
        nameList.addAll(Lists.newArrayList(K_SUB));
        String[] L_SUB = new String[]{"le", "li", "lu", "lai", "lei", "lie", "lan", "lin", "lun", "lang", "ling", "long", "liao", "lian", "luan"};
        nameList.addAll(Lists.newArrayList(L_SUB));
        String[] M_SUB = new String[]{"mi", "mu", "mai", "mei", "mao", "miu", "man", "min", "ming", "mang", "meng", "miao", "mian"};
        nameList.addAll(Lists.newArrayList(M_SUB));
        String[] N_SUB = new String[]{"na", "ni", "niu", "nie", "nan", "nuo", "neng", "ning"};
        nameList.addAll(Lists.newArrayList(N_SUB));
        String[] P_SUB = new String[]{"pi", "pu", "pai", "pei", "pan", "pin", "pang", "peng", "ping", "pian"};
        nameList.addAll(Lists.newArrayList(P_SUB));
        String[] Q_SUB = new String[]{"qi", "qiu", "qing", "qiang", "quan", "qian"};
        nameList.addAll(Lists.newArrayList(Q_SUB));
        String[] S_SUB = new String[]{"sa", "so", "se", "si", "su", "sai", "suo", "sang", "shang", "song", "shong"};
        nameList.addAll(Lists.newArrayList(S_SUB));
        String[] T_SUB = new String[]{"ta", "to", "te", "ti", "tu", "tai", "tao", "tan", "tuo", "tang", "teng", "ting", "tong", "tian"};
        nameList.addAll(Lists.newArrayList(T_SUB));
        String[] W_SUB = new String[]{"wa","wo","wai","wei","wang","wan"};
        nameList.addAll(Lists.newArrayList(W_SUB));
        String[] X_SUB = new String[]{"xi", "xu", "xie", "xin", "xun", "xue", "xing", "xiang", "xiong", "xia", "xian", "xuan"};
        nameList.addAll(Lists.newArrayList(X_SUB));
        String[] Y_SUB = new String[]{"ya", "yi", "yu", "yao", "you", "yan", "yun", "yue", "yin", "yang", "yong", "yuan"};
        nameList.addAll(Lists.newArrayList(Y_SUB));
        String[] Z_SUB = new String[]{"zu","zao","zan","zun","zuo","zeng","zong"};
        nameList.addAll(Lists.newArrayList(Z_SUB));
        String[] ZH_SUB = new String[]{"zhi", "zhou", "zhan", "zhen", "zhang", "zheng", "zhuan"};
        nameList.addAll(Lists.newArrayList(ZH_SUB));
        String[] CH_SUB = new String[]{"cha", "chi", "che", "chu", "chai", "chao", "chan", "cheng", "chang", "chong", "chuan"};
        nameList.addAll(Lists.newArrayList(CH_SUB));
        String[] SH_SUB = new String[]{"sha", "shi", "shu", "shao", "shou", "shan", "shen", "shuo", "shuang"};
        nameList.addAll(Lists.newArrayList(SH_SUB));
    }
    //特殊字符
    public static List<String> MOST_SIN = Lists.newArrayList(new String[]{"~","!","@","#","$","%","^","&","*","(",")","-","+"});
}
