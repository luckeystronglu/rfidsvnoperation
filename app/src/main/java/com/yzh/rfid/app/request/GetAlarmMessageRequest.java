// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: GetAlarmMessageRequest.proto

package com.yzh.rfid.app.request;

public final class GetAlarmMessageRequest {
  private GetAlarmMessageRequest() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface GetAlarmMessageRequestMessageOrBuilder extends
      // @@protoc_insertion_point(interface_extends:GetAlarmMessageRequestMessage)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>optional string session = 1;</code>
     */
    String getSession();
    /**
     * <code>optional string session = 1;</code>
     */
    com.google.protobuf.ByteString
        getSessionBytes();

    /**
     * <pre>
     *消息类型
     * </pre>
     *
     * <code>optional int32 messageType = 2;</code>
     */
    int getMessageType();

    /**
     * <pre>
     *消息子类型
     * </pre>
     *
     * <code>optional int32 messageSubType = 3;</code>
     */
    int getMessageSubType();

    /**
     * <code>optional int32 pageNo = 4;</code>
     */
    int getPageNo();

    /**
     * <code>optional int32 pageSize = 5;</code>
     */
    int getPageSize();

    /**
     * <pre>
     *id列表
     * </pre>
     *
     * <code>optional string ids = 6;</code>
     */
    String getIds();
    /**
     * <pre>
     *id列表
     * </pre>
     *
     * <code>optional string ids = 6;</code>
     */
    com.google.protobuf.ByteString
        getIdsBytes();
  }
  /**
   * Protobuf type {@code GetAlarmMessageRequestMessage}
   */
  public  static final class GetAlarmMessageRequestMessage extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:GetAlarmMessageRequestMessage)
      GetAlarmMessageRequestMessageOrBuilder {
    // Use GetAlarmMessageRequestMessage.newBuilder() to construct.
    private GetAlarmMessageRequestMessage(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private GetAlarmMessageRequestMessage() {
      session_ = "";
      messageType_ = 0;
      messageSubType_ = 0;
      pageNo_ = 0;
      pageSize_ = 0;
      ids_ = "";
    }

    @Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
    }
    private GetAlarmMessageRequestMessage(
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

              session_ = s;
              break;
            }
            case 16: {

              messageType_ = input.readInt32();
              break;
            }
            case 24: {

              messageSubType_ = input.readInt32();
              break;
            }
            case 32: {

              pageNo_ = input.readInt32();
              break;
            }
            case 40: {

              pageSize_ = input.readInt32();
              break;
            }
            case 50: {
              String s = input.readStringRequireUtf8();

              ids_ = s;
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
      return com.yzh.rfid.app.request.GetAlarmMessageRequest.internal_static_GetAlarmMessageRequestMessage_descriptor;
    }

    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.yzh.rfid.app.request.GetAlarmMessageRequest.internal_static_GetAlarmMessageRequestMessage_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.yzh.rfid.app.request.GetAlarmMessageRequest.GetAlarmMessageRequestMessage.class, com.yzh.rfid.app.request.GetAlarmMessageRequest.GetAlarmMessageRequestMessage.Builder.class);
    }

    public static final int SESSION_FIELD_NUMBER = 1;
    private volatile Object session_;
    /**
     * <code>optional string session = 1;</code>
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
     * <code>optional string session = 1;</code>
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

    public static final int MESSAGETYPE_FIELD_NUMBER = 2;
    private int messageType_;
    /**
     * <pre>
     *消息类型
     * </pre>
     *
     * <code>optional int32 messageType = 2;</code>
     */
    public int getMessageType() {
      return messageType_;
    }

    public static final int MESSAGESUBTYPE_FIELD_NUMBER = 3;
    private int messageSubType_;
    /**
     * <pre>
     *消息子类型
     * </pre>
     *
     * <code>optional int32 messageSubType = 3;</code>
     */
    public int getMessageSubType() {
      return messageSubType_;
    }

    public static final int PAGENO_FIELD_NUMBER = 4;
    private int pageNo_;
    /**
     * <code>optional int32 pageNo = 4;</code>
     */
    public int getPageNo() {
      return pageNo_;
    }

    public static final int PAGESIZE_FIELD_NUMBER = 5;
    private int pageSize_;
    /**
     * <code>optional int32 pageSize = 5;</code>
     */
    public int getPageSize() {
      return pageSize_;
    }

    public static final int IDS_FIELD_NUMBER = 6;
    private volatile Object ids_;
    /**
     * <pre>
     *id列表
     * </pre>
     *
     * <code>optional string ids = 6;</code>
     */
    public String getIds() {
      Object ref = ids_;
      if (ref instanceof String) {
        return (String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        ids_ = s;
        return s;
      }
    }
    /**
     * <pre>
     *id列表
     * </pre>
     *
     * <code>optional string ids = 6;</code>
     */
    public com.google.protobuf.ByteString
        getIdsBytes() {
      Object ref = ids_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        ids_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
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
      if (!getSessionBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 1, session_);
      }
      if (messageType_ != 0) {
        output.writeInt32(2, messageType_);
      }
      if (messageSubType_ != 0) {
        output.writeInt32(3, messageSubType_);
      }
      if (pageNo_ != 0) {
        output.writeInt32(4, pageNo_);
      }
      if (pageSize_ != 0) {
        output.writeInt32(5, pageSize_);
      }
      if (!getIdsBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 6, ids_);
      }
    }

    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (!getSessionBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, session_);
      }
      if (messageType_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(2, messageType_);
      }
      if (messageSubType_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(3, messageSubType_);
      }
      if (pageNo_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(4, pageNo_);
      }
      if (pageSize_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(5, pageSize_);
      }
      if (!getIdsBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(6, ids_);
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
      if (!(obj instanceof com.yzh.rfid.app.request.GetAlarmMessageRequest.GetAlarmMessageRequestMessage)) {
        return super.equals(obj);
      }
      com.yzh.rfid.app.request.GetAlarmMessageRequest.GetAlarmMessageRequestMessage other = (com.yzh.rfid.app.request.GetAlarmMessageRequest.GetAlarmMessageRequestMessage) obj;

      boolean result = true;
      result = result && getSession()
          .equals(other.getSession());
      result = result && (getMessageType()
          == other.getMessageType());
      result = result && (getMessageSubType()
          == other.getMessageSubType());
      result = result && (getPageNo()
          == other.getPageNo());
      result = result && (getPageSize()
          == other.getPageSize());
      result = result && getIds()
          .equals(other.getIds());
      return result;
    }

    @Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptorForType().hashCode();
      hash = (37 * hash) + SESSION_FIELD_NUMBER;
      hash = (53 * hash) + getSession().hashCode();
      hash = (37 * hash) + MESSAGETYPE_FIELD_NUMBER;
      hash = (53 * hash) + getMessageType();
      hash = (37 * hash) + MESSAGESUBTYPE_FIELD_NUMBER;
      hash = (53 * hash) + getMessageSubType();
      hash = (37 * hash) + PAGENO_FIELD_NUMBER;
      hash = (53 * hash) + getPageNo();
      hash = (37 * hash) + PAGESIZE_FIELD_NUMBER;
      hash = (53 * hash) + getPageSize();
      hash = (37 * hash) + IDS_FIELD_NUMBER;
      hash = (53 * hash) + getIds().hashCode();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.yzh.rfid.app.request.GetAlarmMessageRequest.GetAlarmMessageRequestMessage parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.yzh.rfid.app.request.GetAlarmMessageRequest.GetAlarmMessageRequestMessage parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.yzh.rfid.app.request.GetAlarmMessageRequest.GetAlarmMessageRequestMessage parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.yzh.rfid.app.request.GetAlarmMessageRequest.GetAlarmMessageRequestMessage parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.yzh.rfid.app.request.GetAlarmMessageRequest.GetAlarmMessageRequestMessage parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.yzh.rfid.app.request.GetAlarmMessageRequest.GetAlarmMessageRequestMessage parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static com.yzh.rfid.app.request.GetAlarmMessageRequest.GetAlarmMessageRequestMessage parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static com.yzh.rfid.app.request.GetAlarmMessageRequest.GetAlarmMessageRequestMessage parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static com.yzh.rfid.app.request.GetAlarmMessageRequest.GetAlarmMessageRequestMessage parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.yzh.rfid.app.request.GetAlarmMessageRequest.GetAlarmMessageRequestMessage parseFrom(
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
    public static Builder newBuilder(com.yzh.rfid.app.request.GetAlarmMessageRequest.GetAlarmMessageRequestMessage prototype) {
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
     * Protobuf type {@code GetAlarmMessageRequestMessage}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:GetAlarmMessageRequestMessage)
        com.yzh.rfid.app.request.GetAlarmMessageRequest.GetAlarmMessageRequestMessageOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return com.yzh.rfid.app.request.GetAlarmMessageRequest.internal_static_GetAlarmMessageRequestMessage_descriptor;
      }

      protected FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.yzh.rfid.app.request.GetAlarmMessageRequest.internal_static_GetAlarmMessageRequestMessage_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.yzh.rfid.app.request.GetAlarmMessageRequest.GetAlarmMessageRequestMessage.class, com.yzh.rfid.app.request.GetAlarmMessageRequest.GetAlarmMessageRequestMessage.Builder.class);
      }

      // Construct using com.yzh.rfid.app.request.GetAlarmMessageRequest.GetAlarmMessageRequestMessage.newBuilder()
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
        session_ = "";

        messageType_ = 0;

        messageSubType_ = 0;

        pageNo_ = 0;

        pageSize_ = 0;

        ids_ = "";

        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return com.yzh.rfid.app.request.GetAlarmMessageRequest.internal_static_GetAlarmMessageRequestMessage_descriptor;
      }

      public com.yzh.rfid.app.request.GetAlarmMessageRequest.GetAlarmMessageRequestMessage getDefaultInstanceForType() {
        return com.yzh.rfid.app.request.GetAlarmMessageRequest.GetAlarmMessageRequestMessage.getDefaultInstance();
      }

      public com.yzh.rfid.app.request.GetAlarmMessageRequest.GetAlarmMessageRequestMessage build() {
        com.yzh.rfid.app.request.GetAlarmMessageRequest.GetAlarmMessageRequestMessage result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public com.yzh.rfid.app.request.GetAlarmMessageRequest.GetAlarmMessageRequestMessage buildPartial() {
        com.yzh.rfid.app.request.GetAlarmMessageRequest.GetAlarmMessageRequestMessage result = new com.yzh.rfid.app.request.GetAlarmMessageRequest.GetAlarmMessageRequestMessage(this);
        result.session_ = session_;
        result.messageType_ = messageType_;
        result.messageSubType_ = messageSubType_;
        result.pageNo_ = pageNo_;
        result.pageSize_ = pageSize_;
        result.ids_ = ids_;
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
        if (other instanceof com.yzh.rfid.app.request.GetAlarmMessageRequest.GetAlarmMessageRequestMessage) {
          return mergeFrom((com.yzh.rfid.app.request.GetAlarmMessageRequest.GetAlarmMessageRequestMessage)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.yzh.rfid.app.request.GetAlarmMessageRequest.GetAlarmMessageRequestMessage other) {
        if (other == com.yzh.rfid.app.request.GetAlarmMessageRequest.GetAlarmMessageRequestMessage.getDefaultInstance()) return this;
        if (!other.getSession().isEmpty()) {
          session_ = other.session_;
          onChanged();
        }
        if (other.getMessageType() != 0) {
          setMessageType(other.getMessageType());
        }
        if (other.getMessageSubType() != 0) {
          setMessageSubType(other.getMessageSubType());
        }
        if (other.getPageNo() != 0) {
          setPageNo(other.getPageNo());
        }
        if (other.getPageSize() != 0) {
          setPageSize(other.getPageSize());
        }
        if (!other.getIds().isEmpty()) {
          ids_ = other.ids_;
          onChanged();
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
        com.yzh.rfid.app.request.GetAlarmMessageRequest.GetAlarmMessageRequestMessage parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (com.yzh.rfid.app.request.GetAlarmMessageRequest.GetAlarmMessageRequestMessage) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private Object session_ = "";
      /**
       * <code>optional string session = 1;</code>
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
       * <code>optional string session = 1;</code>
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
       * <code>optional string session = 1;</code>
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
       * <code>optional string session = 1;</code>
       */
      public Builder clearSession() {
        
        session_ = getDefaultInstance().getSession();
        onChanged();
        return this;
      }
      /**
       * <code>optional string session = 1;</code>
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

      private int messageType_ ;
      /**
       * <pre>
       *消息类型
       * </pre>
       *
       * <code>optional int32 messageType = 2;</code>
       */
      public int getMessageType() {
        return messageType_;
      }
      /**
       * <pre>
       *消息类型
       * </pre>
       *
       * <code>optional int32 messageType = 2;</code>
       */
      public Builder setMessageType(int value) {
        
        messageType_ = value;
        onChanged();
        return this;
      }
      /**
       * <pre>
       *消息类型
       * </pre>
       *
       * <code>optional int32 messageType = 2;</code>
       */
      public Builder clearMessageType() {
        
        messageType_ = 0;
        onChanged();
        return this;
      }

      private int messageSubType_ ;
      /**
       * <pre>
       *消息子类型
       * </pre>
       *
       * <code>optional int32 messageSubType = 3;</code>
       */
      public int getMessageSubType() {
        return messageSubType_;
      }
      /**
       * <pre>
       *消息子类型
       * </pre>
       *
       * <code>optional int32 messageSubType = 3;</code>
       */
      public Builder setMessageSubType(int value) {
        
        messageSubType_ = value;
        onChanged();
        return this;
      }
      /**
       * <pre>
       *消息子类型
       * </pre>
       *
       * <code>optional int32 messageSubType = 3;</code>
       */
      public Builder clearMessageSubType() {
        
        messageSubType_ = 0;
        onChanged();
        return this;
      }

      private int pageNo_ ;
      /**
       * <code>optional int32 pageNo = 4;</code>
       */
      public int getPageNo() {
        return pageNo_;
      }
      /**
       * <code>optional int32 pageNo = 4;</code>
       */
      public Builder setPageNo(int value) {
        
        pageNo_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional int32 pageNo = 4;</code>
       */
      public Builder clearPageNo() {
        
        pageNo_ = 0;
        onChanged();
        return this;
      }

      private int pageSize_ ;
      /**
       * <code>optional int32 pageSize = 5;</code>
       */
      public int getPageSize() {
        return pageSize_;
      }
      /**
       * <code>optional int32 pageSize = 5;</code>
       */
      public Builder setPageSize(int value) {
        
        pageSize_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional int32 pageSize = 5;</code>
       */
      public Builder clearPageSize() {
        
        pageSize_ = 0;
        onChanged();
        return this;
      }

      private Object ids_ = "";
      /**
       * <pre>
       *id列表
       * </pre>
       *
       * <code>optional string ids = 6;</code>
       */
      public String getIds() {
        Object ref = ids_;
        if (!(ref instanceof String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          String s = bs.toStringUtf8();
          ids_ = s;
          return s;
        } else {
          return (String) ref;
        }
      }
      /**
       * <pre>
       *id列表
       * </pre>
       *
       * <code>optional string ids = 6;</code>
       */
      public com.google.protobuf.ByteString
          getIdsBytes() {
        Object ref = ids_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (String) ref);
          ids_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <pre>
       *id列表
       * </pre>
       *
       * <code>optional string ids = 6;</code>
       */
      public Builder setIds(
          String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        ids_ = value;
        onChanged();
        return this;
      }
      /**
       * <pre>
       *id列表
       * </pre>
       *
       * <code>optional string ids = 6;</code>
       */
      public Builder clearIds() {
        
        ids_ = getDefaultInstance().getIds();
        onChanged();
        return this;
      }
      /**
       * <pre>
       *id列表
       * </pre>
       *
       * <code>optional string ids = 6;</code>
       */
      public Builder setIdsBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        ids_ = value;
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


      // @@protoc_insertion_point(builder_scope:GetAlarmMessageRequestMessage)
    }

    // @@protoc_insertion_point(class_scope:GetAlarmMessageRequestMessage)
    private static final com.yzh.rfid.app.request.GetAlarmMessageRequest.GetAlarmMessageRequestMessage DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new com.yzh.rfid.app.request.GetAlarmMessageRequest.GetAlarmMessageRequestMessage();
    }

    public static com.yzh.rfid.app.request.GetAlarmMessageRequest.GetAlarmMessageRequestMessage getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<GetAlarmMessageRequestMessage>
        PARSER = new com.google.protobuf.AbstractParser<GetAlarmMessageRequestMessage>() {
      public GetAlarmMessageRequestMessage parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
          return new GetAlarmMessageRequestMessage(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<GetAlarmMessageRequestMessage> parser() {
      return PARSER;
    }

    @Override
    public com.google.protobuf.Parser<GetAlarmMessageRequestMessage> getParserForType() {
      return PARSER;
    }

    public com.yzh.rfid.app.request.GetAlarmMessageRequest.GetAlarmMessageRequestMessage getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_GetAlarmMessageRequestMessage_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_GetAlarmMessageRequestMessage_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    String[] descriptorData = {
      "\n\034GetAlarmMessageRequest.proto\"\214\001\n\035GetAl" +
      "armMessageRequestMessage\022\017\n\007session\030\001 \001(" +
      "\t\022\023\n\013messageType\030\002 \001(\005\022\026\n\016messageSubType" +
      "\030\003 \001(\005\022\016\n\006pageNo\030\004 \001(\005\022\020\n\010pageSize\030\005 \001(\005" +
      "\022\013\n\003ids\030\006 \001(\tB6\n\034com.yzh.rfid.app.re" +
      "questB\026GetAlarmMessageRequestb\006proto3"
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
    internal_static_GetAlarmMessageRequestMessage_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_GetAlarmMessageRequestMessage_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_GetAlarmMessageRequestMessage_descriptor,
        new String[] { "Session", "MessageType", "MessageSubType", "PageNo", "PageSize", "Ids", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}