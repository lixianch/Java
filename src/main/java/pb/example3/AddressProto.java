// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: pb/proto/Address.proto

package pb.example3;

public final class AddressProto {
  private AddressProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface AddressOrBuilder extends
      // @@protoc_insertion_point(interface_extends:pb.example3.Address)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>optional string street = 1;</code>
     */
    boolean hasStreet();
    /**
     * <code>optional string street = 1;</code>
     */
    java.lang.String getStreet();
    /**
     * <code>optional string street = 1;</code>
     */
    com.google.protobuf.ByteString
        getStreetBytes();

    /**
     * <code>optional string zipcode = 2;</code>
     */
    boolean hasZipcode();
    /**
     * <code>optional string zipcode = 2;</code>
     */
    java.lang.String getZipcode();
    /**
     * <code>optional string zipcode = 2;</code>
     */
    com.google.protobuf.ByteString
        getZipcodeBytes();
  }
  /**
   * Protobuf type {@code pb.example3.Address}
   */
  public  static final class Address extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:pb.example3.Address)
      AddressOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use Address.newBuilder() to construct.
    private Address(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private Address() {
      street_ = "";
      zipcode_ = "";
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private Address(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      int mutable_bitField0_ = 0;
      com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 10: {
              com.google.protobuf.ByteString bs = input.readBytes();
              bitField0_ |= 0x00000001;
              street_ = bs;
              break;
            }
            case 18: {
              com.google.protobuf.ByteString bs = input.readBytes();
              bitField0_ |= 0x00000002;
              zipcode_ = bs;
              break;
            }
            default: {
              if (!parseUnknownField(
                  input, unknownFields, extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e).setUnfinishedMessage(this);
      } finally {
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return pb.example3.AddressProto.internal_static_pb_example3_Address_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return pb.example3.AddressProto.internal_static_pb_example3_Address_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              pb.example3.AddressProto.Address.class, pb.example3.AddressProto.Address.Builder.class);
    }

    private int bitField0_;
    public static final int STREET_FIELD_NUMBER = 1;
    private volatile java.lang.Object street_;
    /**
     * <code>optional string street = 1;</code>
     */
    public boolean hasStreet() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>optional string street = 1;</code>
     */
    public java.lang.String getStreet() {
      java.lang.Object ref = street_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          street_ = s;
        }
        return s;
      }
    }
    /**
     * <code>optional string street = 1;</code>
     */
    public com.google.protobuf.ByteString
        getStreetBytes() {
      java.lang.Object ref = street_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        street_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int ZIPCODE_FIELD_NUMBER = 2;
    private volatile java.lang.Object zipcode_;
    /**
     * <code>optional string zipcode = 2;</code>
     */
    public boolean hasZipcode() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <code>optional string zipcode = 2;</code>
     */
    public java.lang.String getZipcode() {
      java.lang.Object ref = zipcode_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          zipcode_ = s;
        }
        return s;
      }
    }
    /**
     * <code>optional string zipcode = 2;</code>
     */
    public com.google.protobuf.ByteString
        getZipcodeBytes() {
      java.lang.Object ref = zipcode_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        zipcode_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    private byte memoizedIsInitialized = -1;
    @java.lang.Override
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    @java.lang.Override
    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 1, street_);
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 2, zipcode_);
      }
      unknownFields.writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, street_);
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, zipcode_);
      }
      size += unknownFields.getSerializedSize();
      memoizedSize = size;
      return size;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof pb.example3.AddressProto.Address)) {
        return super.equals(obj);
      }
      pb.example3.AddressProto.Address other = (pb.example3.AddressProto.Address) obj;

      boolean result = true;
      result = result && (hasStreet() == other.hasStreet());
      if (hasStreet()) {
        result = result && getStreet()
            .equals(other.getStreet());
      }
      result = result && (hasZipcode() == other.hasZipcode());
      if (hasZipcode()) {
        result = result && getZipcode()
            .equals(other.getZipcode());
      }
      result = result && unknownFields.equals(other.unknownFields);
      return result;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      if (hasStreet()) {
        hash = (37 * hash) + STREET_FIELD_NUMBER;
        hash = (53 * hash) + getStreet().hashCode();
      }
      if (hasZipcode()) {
        hash = (37 * hash) + ZIPCODE_FIELD_NUMBER;
        hash = (53 * hash) + getZipcode().hashCode();
      }
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static pb.example3.AddressProto.Address parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static pb.example3.AddressProto.Address parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static pb.example3.AddressProto.Address parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static pb.example3.AddressProto.Address parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static pb.example3.AddressProto.Address parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static pb.example3.AddressProto.Address parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static pb.example3.AddressProto.Address parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static pb.example3.AddressProto.Address parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static pb.example3.AddressProto.Address parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static pb.example3.AddressProto.Address parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static pb.example3.AddressProto.Address parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static pb.example3.AddressProto.Address parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    @java.lang.Override
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(pb.example3.AddressProto.Address prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    @java.lang.Override
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code pb.example3.Address}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:pb.example3.Address)
        pb.example3.AddressProto.AddressOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return pb.example3.AddressProto.internal_static_pb_example3_Address_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return pb.example3.AddressProto.internal_static_pb_example3_Address_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                pb.example3.AddressProto.Address.class, pb.example3.AddressProto.Address.Builder.class);
      }

      // Construct using pb.example3.AddressProto.Address.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
                .alwaysUseFieldBuilders) {
        }
      }
      @java.lang.Override
      public Builder clear() {
        super.clear();
        street_ = "";
        bitField0_ = (bitField0_ & ~0x00000001);
        zipcode_ = "";
        bitField0_ = (bitField0_ & ~0x00000002);
        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return pb.example3.AddressProto.internal_static_pb_example3_Address_descriptor;
      }

      @java.lang.Override
      public pb.example3.AddressProto.Address getDefaultInstanceForType() {
        return pb.example3.AddressProto.Address.getDefaultInstance();
      }

      @java.lang.Override
      public pb.example3.AddressProto.Address build() {
        pb.example3.AddressProto.Address result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public pb.example3.AddressProto.Address buildPartial() {
        pb.example3.AddressProto.Address result = new pb.example3.AddressProto.Address(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
          to_bitField0_ |= 0x00000001;
        }
        result.street_ = street_;
        if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
          to_bitField0_ |= 0x00000002;
        }
        result.zipcode_ = zipcode_;
        result.bitField0_ = to_bitField0_;
        onBuilt();
        return result;
      }

      @java.lang.Override
      public Builder clone() {
        return (Builder) super.clone();
      }
      @java.lang.Override
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return (Builder) super.setField(field, value);
      }
      @java.lang.Override
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return (Builder) super.clearField(field);
      }
      @java.lang.Override
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return (Builder) super.clearOneof(oneof);
      }
      @java.lang.Override
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, java.lang.Object value) {
        return (Builder) super.setRepeatedField(field, index, value);
      }
      @java.lang.Override
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return (Builder) super.addRepeatedField(field, value);
      }
      @java.lang.Override
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof pb.example3.AddressProto.Address) {
          return mergeFrom((pb.example3.AddressProto.Address)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(pb.example3.AddressProto.Address other) {
        if (other == pb.example3.AddressProto.Address.getDefaultInstance()) return this;
        if (other.hasStreet()) {
          bitField0_ |= 0x00000001;
          street_ = other.street_;
          onChanged();
        }
        if (other.hasZipcode()) {
          bitField0_ |= 0x00000002;
          zipcode_ = other.zipcode_;
          onChanged();
        }
        this.mergeUnknownFields(other.unknownFields);
        onChanged();
        return this;
      }

      @java.lang.Override
      public final boolean isInitialized() {
        return true;
      }

      @java.lang.Override
      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        pb.example3.AddressProto.Address parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (pb.example3.AddressProto.Address) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      private java.lang.Object street_ = "";
      /**
       * <code>optional string street = 1;</code>
       */
      public boolean hasStreet() {
        return ((bitField0_ & 0x00000001) == 0x00000001);
      }
      /**
       * <code>optional string street = 1;</code>
       */
      public java.lang.String getStreet() {
        java.lang.Object ref = street_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          if (bs.isValidUtf8()) {
            street_ = s;
          }
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>optional string street = 1;</code>
       */
      public com.google.protobuf.ByteString
          getStreetBytes() {
        java.lang.Object ref = street_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          street_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>optional string street = 1;</code>
       */
      public Builder setStreet(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000001;
        street_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional string street = 1;</code>
       */
      public Builder clearStreet() {
        bitField0_ = (bitField0_ & ~0x00000001);
        street_ = getDefaultInstance().getStreet();
        onChanged();
        return this;
      }
      /**
       * <code>optional string street = 1;</code>
       */
      public Builder setStreetBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000001;
        street_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object zipcode_ = "";
      /**
       * <code>optional string zipcode = 2;</code>
       */
      public boolean hasZipcode() {
        return ((bitField0_ & 0x00000002) == 0x00000002);
      }
      /**
       * <code>optional string zipcode = 2;</code>
       */
      public java.lang.String getZipcode() {
        java.lang.Object ref = zipcode_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          if (bs.isValidUtf8()) {
            zipcode_ = s;
          }
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>optional string zipcode = 2;</code>
       */
      public com.google.protobuf.ByteString
          getZipcodeBytes() {
        java.lang.Object ref = zipcode_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          zipcode_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>optional string zipcode = 2;</code>
       */
      public Builder setZipcode(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000002;
        zipcode_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional string zipcode = 2;</code>
       */
      public Builder clearZipcode() {
        bitField0_ = (bitField0_ & ~0x00000002);
        zipcode_ = getDefaultInstance().getZipcode();
        onChanged();
        return this;
      }
      /**
       * <code>optional string zipcode = 2;</code>
       */
      public Builder setZipcodeBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000002;
        zipcode_ = value;
        onChanged();
        return this;
      }
      @java.lang.Override
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.setUnknownFields(unknownFields);
      }

      @java.lang.Override
      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.mergeUnknownFields(unknownFields);
      }


      // @@protoc_insertion_point(builder_scope:pb.example3.Address)
    }

    // @@protoc_insertion_point(class_scope:pb.example3.Address)
    private static final pb.example3.AddressProto.Address DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new pb.example3.AddressProto.Address();
    }

    public static pb.example3.AddressProto.Address getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    @java.lang.Deprecated public static final com.google.protobuf.Parser<Address>
        PARSER = new com.google.protobuf.AbstractParser<Address>() {
      @java.lang.Override
      public Address parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new Address(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<Address> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<Address> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public pb.example3.AddressProto.Address getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_pb_example3_Address_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_pb_example3_Address_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\026pb/proto/Address.proto\022\013pb.example3\"*\n" +
      "\007Address\022\016\n\006street\030\001 \001(\t\022\017\n\007zipcode\030\002 \001(" +
      "\tB\033\n\013pb.example3B\014AddressProto"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_pb_example3_Address_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_pb_example3_Address_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_pb_example3_Address_descriptor,
        new java.lang.String[] { "Street", "Zipcode", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
