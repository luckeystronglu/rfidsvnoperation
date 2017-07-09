// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: KeepDeviceReadRecordRequest.proto

package com.yzh.rfid.app.request;

public final class KeepDeviceReadRecordRequest {
  private KeepDeviceReadRecordRequest() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface KeepDeviceReadRecordRequestMessageOrBuilder extends
      // @@protoc_insertion_point(interface_extends:KeepDeviceReadRecordRequestMessage)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>optional string version = 1;</code>
     */
    String getVersion();
    /**
     * <code>optional string version = 1;</code>
     */
    com.google.protobuf.ByteString
        getVersionBytes();

    /**
     * <code>optional string session = 2;</code>
     */
    String getSession();
    /**
     * <code>optional string session = 2;</code>
     */
    com.google.protobuf.ByteString
        getSessionBytes();

    /**
     * <code>optional int64 deviceIdDecimal = 3;</code>
     */
    long getDeviceIdDecimal();
  }
  /**
   * Protobuf type {@code KeepDeviceReadRecordRequestMessage}
   */
  public  static final class KeepDeviceReadRecordRequestMessage extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:KeepDeviceReadRecordRequestMessage)
      KeepDeviceReadRecordRequestMessageOrBuilder {
    // Use KeepDeviceReadRecordRequestMessage.newBuilder() to construct.
    private KeepDeviceReadRecordRequestMessage(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private KeepDeviceReadRecordRequestMessage() {
      version_ = "";
      session_ = "";
      deviceIdDecimal_ = 0L;
    }

    @Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
    }
    private KeepDeviceReadRecordRequestMessage(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      int mutable_bitField0_ = 0;
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!input.skipField(tag)) {
                done = true;
              }
              break;
            }
            case 10: {
              String s = input.readStringRequireUtf8();

              version_ = s;
              break;
            }
            case 18: {
              String s = input.readStringRequireUtf8();

              session_ = s;
              break;
            }
            case 24: {

              deviceIdDecimal_ = input.readInt64();
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
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.yzh.rfid.app.request.KeepDeviceReadRecordRequest.internal_static_KeepDeviceReadRecordRequestMessage_descriptor;
    }

    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.yzh.rfid.app.request.KeepDeviceReadRecordRequest.internal_static_KeepDeviceReadRecordRequestMessage_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.yzh.rfid.app.request.KeepDeviceReadRecordRequest.KeepDeviceReadRecordRequestMessage.class, com.yzh.rfid.app.request.KeepDeviceReadRecordRequest.KeepDeviceReadRecordRequestMessage.Builder.class);
    }

    public static final int VERSION_FIELD_NUMBER = 1;
    private volatile Object version_;
    /**
     * <code>optional string version = 1;</code>
     */
    public String getVersion() {
      Object ref = version_;
      if (ref instanceof String) {
        return (String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        version_ = s;
        return s;
      }
    }
    /**
     * <code>optional string version = 1;</code>
     */
    public com.google.protobuf.ByteString
        getVersionBytes() {
      Object ref = version_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        version_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int SESSION_FIELD_NUMBER = 2;
    private volatile Object session_;
    /**
     * <code>optional string session = 2;</code>
     */
    public String getSession() {
      Object ref = session_;
      if (ref instanceof String) {
        return (String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        session_ = s;
        return s;
      }
    }
    /**
     * <code>optional string session = 2;</code>
     */
    public com.google.protobuf.ByteString
        getSessionBytes() {
      Object ref = session_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        session_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int DEVICEIDDECIMAL_FIELD_NUMBER = 3;
    private long deviceIdDecimal_;
    /**
     * <code>optional int64 deviceIdDecimal = 3;</code>
     */
    public long getDeviceIdDecimal() {
      return deviceIdDecimal_;
    }

    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (!getVersionBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 1, version_);
      }
      if (!getSessionBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 2, session_);
      }
      if (deviceIdDecimal_ != 0L) {
        output.writeInt64(3, deviceIdDecimal_);
      }
    }

    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (!getVersionBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, version_);
      }
      if (!getSessionBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, session_);
      }
      if (deviceIdDecimal_ != 0L) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt64Size(3, deviceIdDecimal_);
      }
      memoizedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    @Override
    public boolean equals(final Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof com.yzh.rfid.app.request.KeepDeviceReadRecordRequest.KeepDeviceReadRecordRequestMessage)) {
        return super.equals(obj);
      }
      com.yzh.rfid.app.request.KeepDeviceReadRecordRequest.KeepDeviceReadRecordRequestMessage other = (com.yzh.rfid.app.request.KeepDeviceReadRecordRequest.KeepDeviceReadRecordRequestMessage) obj;

      boolean result = true;
      result = result && getVersion()
          .equals(other.getVersion());
      result = result && getSession()
          .equals(other.getSession());
      result = result && (getDeviceIdDecimal()
          == other.getDeviceIdDecimal());
      return result;
    }

    @Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptorForType().hashCode();
      hash = (37 * hash) + VERSION_FIELD_NUMBER;
      hash = (53 * hash) + getVersion().hashCode();
      hash = (37 * hash) + SESSION_FIELD_NUMBER;
      hash = (53 * hash) + getSession().hashCode();
      hash = (37 * hash) + DEVICEIDDECIMAL_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
          getDeviceIdDecimal());
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.yzh.rfid.app.request.KeepDeviceReadRecordRequest.KeepDeviceReadRecordRequestMessage parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.yzh.rfid.app.request.KeepDeviceReadRecordRequest.KeepDeviceReadRecordRequestMessage parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.yzh.rfid.app.request.KeepDeviceReadRecordRequest.KeepDeviceReadRecordRequestMessage parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.yzh.rfid.app.request.KeepDeviceReadRecordRequest.KeepDeviceReadRecordRequestMessage parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.yzh.rfid.app.request.KeepDeviceReadRecordRequest.KeepDeviceReadRecordRequestMessage parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.yzh.rfid.app.request.KeepDeviceReadRecordRequest.KeepDeviceReadRecordRequestMessage parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static com.yzh.rfid.app.request.KeepDeviceReadRecordRequest.KeepDeviceReadRecordRequestMessage parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static com.yzh.rfid.app.request.KeepDeviceReadRecordRequest.KeepDeviceReadRecordRequestMessage parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static com.yzh.rfid.app.request.KeepDeviceReadRecordRequest.KeepDeviceReadRecordRequestMessage parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.yzh.rfid.app.request.KeepDeviceReadRecordRequest.KeepDeviceReadRecordRequestMessage parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(com.yzh.rfid.app.request.KeepDeviceReadRecordRequest.KeepDeviceReadRecordRequestMessage prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @Override
    protected Builder newBuilderForType(
        BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code KeepDeviceReadRecordRequestMessage}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:KeepDeviceReadRecordRequestMessage)
        com.yzh.rfid.app.request.KeepDeviceReadRecordRequest.KeepDeviceReadRecordRequestMessageOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return com.yzh.rfid.app.request.KeepDeviceReadRecordRequest.internal_static_KeepDeviceReadRecordRequestMessage_descriptor;
      }

      protected FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.yzh.rfid.app.request.KeepDeviceReadRecordRequest.internal_static_KeepDeviceReadRecordRequestMessage_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.yzh.rfid.app.request.KeepDeviceReadRecordRequest.KeepDeviceReadRecordRequestMessage.class, com.yzh.rfid.app.request.KeepDeviceReadRecordRequest.KeepDeviceReadRecordRequestMessage.Builder.class);
      }

      // Construct using com.yzh.rfid.app.request.KeepDeviceReadRecordRequest.KeepDeviceReadRecordRequestMessage.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
                .alwaysUseFieldBuilders) {
        }
      }
      public Builder clear() {
        super.clear();
        version_ = "";

        session_ = "";

        deviceIdDecimal_ = 0L;

        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return com.yzh.rfid.app.request.KeepDeviceReadRecordRequest.internal_static_KeepDeviceReadRecordRequestMessage_descriptor;
      }

      public com.yzh.rfid.app.request.KeepDeviceReadRecordRequest.KeepDeviceReadRecordRequestMessage getDefaultInstanceForType() {
        return com.yzh.rfid.app.request.KeepDeviceReadRecordRequest.KeepDeviceReadRecordRequestMessage.getDefaultInstance();
      }

      public com.yzh.rfid.app.request.KeepDeviceReadRecordRequest.KeepDeviceReadRecordRequestMessage build() {
        com.yzh.rfid.app.request.KeepDeviceReadRecordRequest.KeepDeviceReadRecordRequestMessage result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public com.yzh.rfid.app.request.KeepDeviceReadRecordRequest.KeepDeviceReadRecordRequestMessage buildPartial() {
        com.yzh.rfid.app.request.KeepDeviceReadRecordRequest.KeepDeviceReadRecordRequestMessage result = new com.yzh.rfid.app.request.KeepDeviceReadRecordRequest.KeepDeviceReadRecordRequestMessage(this);
        result.version_ = version_;
        result.session_ = session_;
        result.deviceIdDecimal_ = deviceIdDecimal_;
        onBuilt();
        return result;
      }

      public Builder clone() {
        return (Builder) super.clone();
      }
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return (Builder) super.setField(field, value);
      }
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return (Builder) super.clearField(field);
      }
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return (Builder) super.clearOneof(oneof);
      }
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, Object value) {
        return (Builder) super.setRepeatedField(field, index, value);
      }
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return (Builder) super.addRepeatedField(field, value);
      }
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof com.yzh.rfid.app.request.KeepDeviceReadRecordRequest.KeepDeviceReadRecordRequestMessage) {
          return mergeFrom((com.yzh.rfid.app.request.KeepDeviceReadRecordRequest.KeepDeviceReadRecordRequestMessage)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.yzh.rfid.app.request.KeepDeviceReadRecordRequest.KeepDeviceReadRecordRequestMessage other) {
        if (other == com.yzh.rfid.app.request.KeepDeviceReadRecordRequest.KeepDeviceReadRecordRequestMessage.getDefaultInstance()) return this;
        if (!other.getVersion().isEmpty()) {
          version_ = other.version_;
          onChanged();
        }
        if (!other.getSession().isEmpty()) {
          session_ = other.session_;
          onChanged();
        }
        if (other.getDeviceIdDecimal() != 0L) {
          setDeviceIdDecimal(other.getDeviceIdDecimal());
        }
        onChanged();
        return this;
      }

      public final boolean isInitialized() {
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        com.yzh.rfid.app.request.KeepDeviceReadRecordRequest.KeepDeviceReadRecordRequestMessage parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (com.yzh.rfid.app.request.KeepDeviceReadRecordRequest.KeepDeviceReadRecordRequestMessage) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private Object version_ = "";
      /**
       * <code>optional string version = 1;</code>
       */
      public String getVersion() {
        Object ref = version_;
        if (!(ref instanceof String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          String s = bs.toStringUtf8();
          version_ = s;
          return s;
        } else {
          return (String) ref;
        }
      }
      /**
       * <code>optional string version = 1;</code>
       */
      public com.google.protobuf.ByteString
          getVersionBytes() {
        Object ref = version_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (String) ref);
          version_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>optional string version = 1;</code>
       */
      public Builder setVersion(
          String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        version_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional string version = 1;</code>
       */
      public Builder clearVersion() {
        
        version_ = getDefaultInstance().getVersion();
        onChanged();
        return this;
      }
      /**
       * <code>optional string version = 1;</code>
       */
      public Builder setVersionBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        version_ = value;
        onChanged();
        return this;
      }

      private Object session_ = "";
      /**
       * <code>optional string session = 2;</code>
       */
      public String getSession() {
        Object ref = session_;
        if (!(ref instanceof String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          String s = bs.toStringUtf8();
          session_ = s;
          return s;
        } else {
          return (String) ref;
        }
      }
      /**
       * <code>optional string session = 2;</code>
       */
      public com.google.protobuf.ByteString
          getSessionBytes() {
        Object ref = session_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (String) ref);
          session_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>optional string session = 2;</code>
       */
      public Builder setSession(
          String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        session_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional string session = 2;</code>
       */
      public Builder clearSession() {
        
        session_ = getDefaultInstance().getSession();
        onChanged();
        return this;
      }
      /**
       * <code>optional string session = 2;</code>
       */
      public Builder setSessionBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        session_ = value;
        onChanged();
        return this;
      }

      private long deviceIdDecimal_ ;
      /**
       * <code>optional int64 deviceIdDecimal = 3;</code>
       */
      public long getDeviceIdDecimal() {
        return deviceIdDecimal_;
      }
      /**
       * <code>optional int64 deviceIdDecimal = 3;</code>
       */
      public Builder setDeviceIdDecimal(long value) {
        
        deviceIdDecimal_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional int64 deviceIdDecimal = 3;</code>
       */
      public Builder clearDeviceIdDecimal() {
        
        deviceIdDecimal_ = 0L;
        onChanged();
        return this;
      }
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return this;
      }

      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return this;
      }


      // @@protoc_insertion_point(builder_scope:KeepDeviceReadRecordRequestMessage)
    }

    // @@protoc_insertion_point(class_scope:KeepDeviceReadRecordRequestMessage)
    private static final com.yzh.rfid.app.request.KeepDeviceReadRecordRequest.KeepDeviceReadRecordRequestMessage DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new com.yzh.rfid.app.request.KeepDeviceReadRecordRequest.KeepDeviceReadRecordRequestMessage();
    }

    public static com.yzh.rfid.app.request.KeepDeviceReadRecordRequest.KeepDeviceReadRecordRequestMessage getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<KeepDeviceReadRecordRequestMessage>
        PARSER = new com.google.protobuf.AbstractParser<KeepDeviceReadRecordRequestMessage>() {
      public KeepDeviceReadRecordRequestMessage parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
          return new KeepDeviceReadRecordRequestMessage(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<KeepDeviceReadRecordRequestMessage> parser() {
      return PARSER;
    }

    @Override
    public com.google.protobuf.Parser<KeepDeviceReadRecordRequestMessage> getParserForType() {
      return PARSER;
    }

    public com.yzh.rfid.app.request.KeepDeviceReadRecordRequest.KeepDeviceReadRecordRequestMessage getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_KeepDeviceReadRecordRequestMessage_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_KeepDeviceReadRecordRequestMessage_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    String[] descriptorData = {
      "\n!KeepDeviceReadRecordRequest.proto\"_\n\"K" +
      "eepDeviceReadRecordRequestMessage\022\017\n\007ver" +
      "sion\030\001 \001(\t\022\017\n\007session\030\002 \001(\t\022\027\n\017deviceIdD" +
      "ecimal\030\003 \001(\003B;\n\034com.yzh.rfid.app.req" +
      "uestB\033KeepDeviceReadRecordRequestb\006proto" +
      "3"
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
    internal_static_KeepDeviceReadRecordRequestMessage_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_KeepDeviceReadRecordRequestMessage_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_KeepDeviceReadRecordRequestMessage_descriptor,
        new String[] { "Version", "Session", "DeviceIdDecimal", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}