// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ConfigRFInfoRequest.proto

package com.yzh.rfid.app.request;

public final class ConfigRFInfoRequest {
  private ConfigRFInfoRequest() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface ConfigRFInfoRequestMessageOrBuilder extends
      // @@protoc_insertion_point(interface_extends:ConfigRFInfoRequestMessage)
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
     * <code>optional string deviceId = 2;</code>
     */
    String getDeviceId();
    /**
     * <code>optional string deviceId = 2;</code>
     */
    com.google.protobuf.ByteString
        getDeviceIdBytes();

    /**
     * <pre>
     *2.4G 接收衰减,RF 衰减度[0~127]
     * </pre>
     *
     * <code>optional int32 damp24G = 3;</code>
     */
    int getDamp24G();

    /**
     * <pre>
     *2.4G 接收频道,RF 通道频点: [0~99]
     * </pre>
     *
     * <code>optional int32 channel24G = 4;</code>
     */
    int getChannel24G();

    /**
     * <pre>
     *过滤时间,[0~255]
     * </pre>
     *
     * <code>optional int32 filterSeconds = 5;</code>
     */
    int getFilterSeconds();

    /**
     * <pre>
     *433M 接收衰减,RF433 衰减度[0~127]
     * </pre>
     *
     * <code>optional int32 damp433M = 6;</code>
     */
    int getDamp433M();

    /**
     * <pre>
     *433 接收频道,RF433 通道频点:[0~99]
     * </pre>
     *
     * <code>optional int32 channel433M = 7;</code>
     */
    int getChannel433M();
  }
  /**
   * Protobuf type {@code ConfigRFInfoRequestMessage}
   */
  public  static final class ConfigRFInfoRequestMessage extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:ConfigRFInfoRequestMessage)
      ConfigRFInfoRequestMessageOrBuilder {
    // Use ConfigRFInfoRequestMessage.newBuilder() to construct.
    private ConfigRFInfoRequestMessage(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private ConfigRFInfoRequestMessage() {
      version_ = "";
      deviceId_ = "";
      damp24G_ = 0;
      channel24G_ = 0;
      filterSeconds_ = 0;
      damp433M_ = 0;
      channel433M_ = 0;
    }

    @Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
    }
    private ConfigRFInfoRequestMessage(
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

              deviceId_ = s;
              break;
            }
            case 24: {

              damp24G_ = input.readInt32();
              break;
            }
            case 32: {

              channel24G_ = input.readInt32();
              break;
            }
            case 40: {

              filterSeconds_ = input.readInt32();
              break;
            }
            case 48: {

              damp433M_ = input.readInt32();
              break;
            }
            case 56: {

              channel433M_ = input.readInt32();
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
      return com.yzh.rfid.app.request.ConfigRFInfoRequest.internal_static_ConfigRFInfoRequestMessage_descriptor;
    }

    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.yzh.rfid.app.request.ConfigRFInfoRequest.internal_static_ConfigRFInfoRequestMessage_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.yzh.rfid.app.request.ConfigRFInfoRequest.ConfigRFInfoRequestMessage.class, com.yzh.rfid.app.request.ConfigRFInfoRequest.ConfigRFInfoRequestMessage.Builder.class);
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

    public static final int DEVICEID_FIELD_NUMBER = 2;
    private volatile Object deviceId_;
    /**
     * <code>optional string deviceId = 2;</code>
     */
    public String getDeviceId() {
      Object ref = deviceId_;
      if (ref instanceof String) {
        return (String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        deviceId_ = s;
        return s;
      }
    }
    /**
     * <code>optional string deviceId = 2;</code>
     */
    public com.google.protobuf.ByteString
        getDeviceIdBytes() {
      Object ref = deviceId_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        deviceId_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int DAMP24G_FIELD_NUMBER = 3;
    private int damp24G_;
    /**
     * <pre>
     *2.4G 接收衰减,RF 衰减度[0~127]
     * </pre>
     *
     * <code>optional int32 damp24G = 3;</code>
     */
    public int getDamp24G() {
      return damp24G_;
    }

    public static final int CHANNEL24G_FIELD_NUMBER = 4;
    private int channel24G_;
    /**
     * <pre>
     *2.4G 接收频道,RF 通道频点: [0~99]
     * </pre>
     *
     * <code>optional int32 channel24G = 4;</code>
     */
    public int getChannel24G() {
      return channel24G_;
    }

    public static final int FILTERSECONDS_FIELD_NUMBER = 5;
    private int filterSeconds_;
    /**
     * <pre>
     *过滤时间,[0~255]
     * </pre>
     *
     * <code>optional int32 filterSeconds = 5;</code>
     */
    public int getFilterSeconds() {
      return filterSeconds_;
    }

    public static final int DAMP433M_FIELD_NUMBER = 6;
    private int damp433M_;
    /**
     * <pre>
     *433M 接收衰减,RF433 衰减度[0~127]
     * </pre>
     *
     * <code>optional int32 damp433M = 6;</code>
     */
    public int getDamp433M() {
      return damp433M_;
    }

    public static final int CHANNEL433M_FIELD_NUMBER = 7;
    private int channel433M_;
    /**
     * <pre>
     *433 接收频道,RF433 通道频点:[0~99]
     * </pre>
     *
     * <code>optional int32 channel433M = 7;</code>
     */
    public int getChannel433M() {
      return channel433M_;
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
      if (!getDeviceIdBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 2, deviceId_);
      }
      if (damp24G_ != 0) {
        output.writeInt32(3, damp24G_);
      }
      if (channel24G_ != 0) {
        output.writeInt32(4, channel24G_);
      }
      if (filterSeconds_ != 0) {
        output.writeInt32(5, filterSeconds_);
      }
      if (damp433M_ != 0) {
        output.writeInt32(6, damp433M_);
      }
      if (channel433M_ != 0) {
        output.writeInt32(7, channel433M_);
      }
    }

    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (!getVersionBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, version_);
      }
      if (!getDeviceIdBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, deviceId_);
      }
      if (damp24G_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(3, damp24G_);
      }
      if (channel24G_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(4, channel24G_);
      }
      if (filterSeconds_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(5, filterSeconds_);
      }
      if (damp433M_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(6, damp433M_);
      }
      if (channel433M_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(7, channel433M_);
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
      if (!(obj instanceof com.yzh.rfid.app.request.ConfigRFInfoRequest.ConfigRFInfoRequestMessage)) {
        return super.equals(obj);
      }
      com.yzh.rfid.app.request.ConfigRFInfoRequest.ConfigRFInfoRequestMessage other = (com.yzh.rfid.app.request.ConfigRFInfoRequest.ConfigRFInfoRequestMessage) obj;

      boolean result = true;
      result = result && getVersion()
          .equals(other.getVersion());
      result = result && getDeviceId()
          .equals(other.getDeviceId());
      result = result && (getDamp24G()
          == other.getDamp24G());
      result = result && (getChannel24G()
          == other.getChannel24G());
      result = result && (getFilterSeconds()
          == other.getFilterSeconds());
      result = result && (getDamp433M()
          == other.getDamp433M());
      result = result && (getChannel433M()
          == other.getChannel433M());
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
      hash = (37 * hash) + DEVICEID_FIELD_NUMBER;
      hash = (53 * hash) + getDeviceId().hashCode();
      hash = (37 * hash) + DAMP24G_FIELD_NUMBER;
      hash = (53 * hash) + getDamp24G();
      hash = (37 * hash) + CHANNEL24G_FIELD_NUMBER;
      hash = (53 * hash) + getChannel24G();
      hash = (37 * hash) + FILTERSECONDS_FIELD_NUMBER;
      hash = (53 * hash) + getFilterSeconds();
      hash = (37 * hash) + DAMP433M_FIELD_NUMBER;
      hash = (53 * hash) + getDamp433M();
      hash = (37 * hash) + CHANNEL433M_FIELD_NUMBER;
      hash = (53 * hash) + getChannel433M();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.yzh.rfid.app.request.ConfigRFInfoRequest.ConfigRFInfoRequestMessage parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.yzh.rfid.app.request.ConfigRFInfoRequest.ConfigRFInfoRequestMessage parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.yzh.rfid.app.request.ConfigRFInfoRequest.ConfigRFInfoRequestMessage parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.yzh.rfid.app.request.ConfigRFInfoRequest.ConfigRFInfoRequestMessage parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.yzh.rfid.app.request.ConfigRFInfoRequest.ConfigRFInfoRequestMessage parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.yzh.rfid.app.request.ConfigRFInfoRequest.ConfigRFInfoRequestMessage parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static com.yzh.rfid.app.request.ConfigRFInfoRequest.ConfigRFInfoRequestMessage parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static com.yzh.rfid.app.request.ConfigRFInfoRequest.ConfigRFInfoRequestMessage parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static com.yzh.rfid.app.request.ConfigRFInfoRequest.ConfigRFInfoRequestMessage parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.yzh.rfid.app.request.ConfigRFInfoRequest.ConfigRFInfoRequestMessage parseFrom(
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
    public static Builder newBuilder(com.yzh.rfid.app.request.ConfigRFInfoRequest.ConfigRFInfoRequestMessage prototype) {
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
     * Protobuf type {@code ConfigRFInfoRequestMessage}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:ConfigRFInfoRequestMessage)
        com.yzh.rfid.app.request.ConfigRFInfoRequest.ConfigRFInfoRequestMessageOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return com.yzh.rfid.app.request.ConfigRFInfoRequest.internal_static_ConfigRFInfoRequestMessage_descriptor;
      }

      protected FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.yzh.rfid.app.request.ConfigRFInfoRequest.internal_static_ConfigRFInfoRequestMessage_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.yzh.rfid.app.request.ConfigRFInfoRequest.ConfigRFInfoRequestMessage.class, com.yzh.rfid.app.request.ConfigRFInfoRequest.ConfigRFInfoRequestMessage.Builder.class);
      }

      // Construct using com.yzh.rfid.app.request.ConfigRFInfoRequest.ConfigRFInfoRequestMessage.newBuilder()
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

        deviceId_ = "";

        damp24G_ = 0;

        channel24G_ = 0;

        filterSeconds_ = 0;

        damp433M_ = 0;

        channel433M_ = 0;

        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return com.yzh.rfid.app.request.ConfigRFInfoRequest.internal_static_ConfigRFInfoRequestMessage_descriptor;
      }

      public com.yzh.rfid.app.request.ConfigRFInfoRequest.ConfigRFInfoRequestMessage getDefaultInstanceForType() {
        return com.yzh.rfid.app.request.ConfigRFInfoRequest.ConfigRFInfoRequestMessage.getDefaultInstance();
      }

      public com.yzh.rfid.app.request.ConfigRFInfoRequest.ConfigRFInfoRequestMessage build() {
        com.yzh.rfid.app.request.ConfigRFInfoRequest.ConfigRFInfoRequestMessage result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public com.yzh.rfid.app.request.ConfigRFInfoRequest.ConfigRFInfoRequestMessage buildPartial() {
        com.yzh.rfid.app.request.ConfigRFInfoRequest.ConfigRFInfoRequestMessage result = new com.yzh.rfid.app.request.ConfigRFInfoRequest.ConfigRFInfoRequestMessage(this);
        result.version_ = version_;
        result.deviceId_ = deviceId_;
        result.damp24G_ = damp24G_;
        result.channel24G_ = channel24G_;
        result.filterSeconds_ = filterSeconds_;
        result.damp433M_ = damp433M_;
        result.channel433M_ = channel433M_;
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
        if (other instanceof com.yzh.rfid.app.request.ConfigRFInfoRequest.ConfigRFInfoRequestMessage) {
          return mergeFrom((com.yzh.rfid.app.request.ConfigRFInfoRequest.ConfigRFInfoRequestMessage)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.yzh.rfid.app.request.ConfigRFInfoRequest.ConfigRFInfoRequestMessage other) {
        if (other == com.yzh.rfid.app.request.ConfigRFInfoRequest.ConfigRFInfoRequestMessage.getDefaultInstance()) return this;
        if (!other.getVersion().isEmpty()) {
          version_ = other.version_;
          onChanged();
        }
        if (!other.getDeviceId().isEmpty()) {
          deviceId_ = other.deviceId_;
          onChanged();
        }
        if (other.getDamp24G() != 0) {
          setDamp24G(other.getDamp24G());
        }
        if (other.getChannel24G() != 0) {
          setChannel24G(other.getChannel24G());
        }
        if (other.getFilterSeconds() != 0) {
          setFilterSeconds(other.getFilterSeconds());
        }
        if (other.getDamp433M() != 0) {
          setDamp433M(other.getDamp433M());
        }
        if (other.getChannel433M() != 0) {
          setChannel433M(other.getChannel433M());
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
        com.yzh.rfid.app.request.ConfigRFInfoRequest.ConfigRFInfoRequestMessage parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (com.yzh.rfid.app.request.ConfigRFInfoRequest.ConfigRFInfoRequestMessage) e.getUnfinishedMessage();
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

      private Object deviceId_ = "";
      /**
       * <code>optional string deviceId = 2;</code>
       */
      public String getDeviceId() {
        Object ref = deviceId_;
        if (!(ref instanceof String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          String s = bs.toStringUtf8();
          deviceId_ = s;
          return s;
        } else {
          return (String) ref;
        }
      }
      /**
       * <code>optional string deviceId = 2;</code>
       */
      public com.google.protobuf.ByteString
          getDeviceIdBytes() {
        Object ref = deviceId_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (String) ref);
          deviceId_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>optional string deviceId = 2;</code>
       */
      public Builder setDeviceId(
          String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        deviceId_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional string deviceId = 2;</code>
       */
      public Builder clearDeviceId() {
        
        deviceId_ = getDefaultInstance().getDeviceId();
        onChanged();
        return this;
      }
      /**
       * <code>optional string deviceId = 2;</code>
       */
      public Builder setDeviceIdBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        deviceId_ = value;
        onChanged();
        return this;
      }

      private int damp24G_ ;
      /**
       * <pre>
       *2.4G 接收衰减,RF 衰减度[0~127]
       * </pre>
       *
       * <code>optional int32 damp24G = 3;</code>
       */
      public int getDamp24G() {
        return damp24G_;
      }
      /**
       * <pre>
       *2.4G 接收衰减,RF 衰减度[0~127]
       * </pre>
       *
       * <code>optional int32 damp24G = 3;</code>
       */
      public Builder setDamp24G(int value) {
        
        damp24G_ = value;
        onChanged();
        return this;
      }
      /**
       * <pre>
       *2.4G 接收衰减,RF 衰减度[0~127]
       * </pre>
       *
       * <code>optional int32 damp24G = 3;</code>
       */
      public Builder clearDamp24G() {
        
        damp24G_ = 0;
        onChanged();
        return this;
      }

      private int channel24G_ ;
      /**
       * <pre>
       *2.4G 接收频道,RF 通道频点: [0~99]
       * </pre>
       *
       * <code>optional int32 channel24G = 4;</code>
       */
      public int getChannel24G() {
        return channel24G_;
      }
      /**
       * <pre>
       *2.4G 接收频道,RF 通道频点: [0~99]
       * </pre>
       *
       * <code>optional int32 channel24G = 4;</code>
       */
      public Builder setChannel24G(int value) {
        
        channel24G_ = value;
        onChanged();
        return this;
      }
      /**
       * <pre>
       *2.4G 接收频道,RF 通道频点: [0~99]
       * </pre>
       *
       * <code>optional int32 channel24G = 4;</code>
       */
      public Builder clearChannel24G() {
        
        channel24G_ = 0;
        onChanged();
        return this;
      }

      private int filterSeconds_ ;
      /**
       * <pre>
       *过滤时间,[0~255]
       * </pre>
       *
       * <code>optional int32 filterSeconds = 5;</code>
       */
      public int getFilterSeconds() {
        return filterSeconds_;
      }
      /**
       * <pre>
       *过滤时间,[0~255]
       * </pre>
       *
       * <code>optional int32 filterSeconds = 5;</code>
       */
      public Builder setFilterSeconds(int value) {
        
        filterSeconds_ = value;
        onChanged();
        return this;
      }
      /**
       * <pre>
       *过滤时间,[0~255]
       * </pre>
       *
       * <code>optional int32 filterSeconds = 5;</code>
       */
      public Builder clearFilterSeconds() {
        
        filterSeconds_ = 0;
        onChanged();
        return this;
      }

      private int damp433M_ ;
      /**
       * <pre>
       *433M 接收衰减,RF433 衰减度[0~127]
       * </pre>
       *
       * <code>optional int32 damp433M = 6;</code>
       */
      public int getDamp433M() {
        return damp433M_;
      }
      /**
       * <pre>
       *433M 接收衰减,RF433 衰减度[0~127]
       * </pre>
       *
       * <code>optional int32 damp433M = 6;</code>
       */
      public Builder setDamp433M(int value) {
        
        damp433M_ = value;
        onChanged();
        return this;
      }
      /**
       * <pre>
       *433M 接收衰减,RF433 衰减度[0~127]
       * </pre>
       *
       * <code>optional int32 damp433M = 6;</code>
       */
      public Builder clearDamp433M() {
        
        damp433M_ = 0;
        onChanged();
        return this;
      }

      private int channel433M_ ;
      /**
       * <pre>
       *433 接收频道,RF433 通道频点:[0~99]
       * </pre>
       *
       * <code>optional int32 channel433M = 7;</code>
       */
      public int getChannel433M() {
        return channel433M_;
      }
      /**
       * <pre>
       *433 接收频道,RF433 通道频点:[0~99]
       * </pre>
       *
       * <code>optional int32 channel433M = 7;</code>
       */
      public Builder setChannel433M(int value) {
        
        channel433M_ = value;
        onChanged();
        return this;
      }
      /**
       * <pre>
       *433 接收频道,RF433 通道频点:[0~99]
       * </pre>
       *
       * <code>optional int32 channel433M = 7;</code>
       */
      public Builder clearChannel433M() {
        
        channel433M_ = 0;
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


      // @@protoc_insertion_point(builder_scope:ConfigRFInfoRequestMessage)
    }

    // @@protoc_insertion_point(class_scope:ConfigRFInfoRequestMessage)
    private static final com.yzh.rfid.app.request.ConfigRFInfoRequest.ConfigRFInfoRequestMessage DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new com.yzh.rfid.app.request.ConfigRFInfoRequest.ConfigRFInfoRequestMessage();
    }

    public static com.yzh.rfid.app.request.ConfigRFInfoRequest.ConfigRFInfoRequestMessage getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<ConfigRFInfoRequestMessage>
        PARSER = new com.google.protobuf.AbstractParser<ConfigRFInfoRequestMessage>() {
      public ConfigRFInfoRequestMessage parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
          return new ConfigRFInfoRequestMessage(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<ConfigRFInfoRequestMessage> parser() {
      return PARSER;
    }

    @Override
    public com.google.protobuf.Parser<ConfigRFInfoRequestMessage> getParserForType() {
      return PARSER;
    }

    public com.yzh.rfid.app.request.ConfigRFInfoRequest.ConfigRFInfoRequestMessage getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ConfigRFInfoRequestMessage_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ConfigRFInfoRequestMessage_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    String[] descriptorData = {
      "\n\031ConfigRFInfoRequest.proto\"\242\001\n\032ConfigRF" +
      "InfoRequestMessage\022\017\n\007version\030\001 \001(\t\022\020\n\010d" +
      "eviceId\030\002 \001(\t\022\017\n\007damp24G\030\003 \001(\005\022\022\n\nchanne" +
      "l24G\030\004 \001(\005\022\025\n\rfilterSeconds\030\005 \001(\005\022\020\n\010dam" +
      "p433M\030\006 \001(\005\022\023\n\013channel433M\030\007 \001(\005B:\n#com." +
      "yzh.rfid.app.requestB\023ConfigR" +
      "FInfoRequestb\006proto3"
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
    internal_static_ConfigRFInfoRequestMessage_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_ConfigRFInfoRequestMessage_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ConfigRFInfoRequestMessage_descriptor,
        new String[] { "Version", "DeviceId", "Damp24G", "Channel24G", "FilterSeconds", "Damp433M", "Channel433M", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
