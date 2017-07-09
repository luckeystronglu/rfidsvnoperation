// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: GetDeviceTypeRequest.proto

package com.yzh.rfid.app.request;

public final class GetDeviceTypeRequest {
  private GetDeviceTypeRequest() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface GetDeviceTypeRequestMessageOrBuilder extends
      // @@protoc_insertion_point(interface_extends:GetDeviceTypeRequestMessage)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <pre>
     *session
     * </pre>
     *
     * <code>optional string session = 1;</code>
     */
    String getSession();
    /**
     * <pre>
     *session
     * </pre>
     *
     * <code>optional string session = 1;</code>
     */
    com.google.protobuf.ByteString
        getSessionBytes();

    /**
     * <pre>
     *类型
     * </pre>
     *
     * <code>optional string type = 2;</code>
     */
    String getType();
    /**
     * <pre>
     *类型
     * </pre>
     *
     * <code>optional string type = 2;</code>
     */
    com.google.protobuf.ByteString
        getTypeBytes();
  }
  /**
   * <pre>
   * [运维App] 获取基站类型
   * </pre>
   *
   * Protobuf type {@code GetDeviceTypeRequestMessage}
   */
  public  static final class GetDeviceTypeRequestMessage extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:GetDeviceTypeRequestMessage)
      GetDeviceTypeRequestMessageOrBuilder {
    // Use GetDeviceTypeRequestMessage.newBuilder() to construct.
    private GetDeviceTypeRequestMessage(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private GetDeviceTypeRequestMessage() {
      session_ = "";
      type_ = "";
    }

    @Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
    }
    private GetDeviceTypeRequestMessage(
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
            case 18: {
              String s = input.readStringRequireUtf8();

              type_ = s;
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
      return com.yzh.rfid.app.request.GetDeviceTypeRequest.internal_static_GetDeviceTypeRequestMessage_descriptor;
    }

    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.yzh.rfid.app.request.GetDeviceTypeRequest.internal_static_GetDeviceTypeRequestMessage_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.yzh.rfid.app.request.GetDeviceTypeRequest.GetDeviceTypeRequestMessage.class, com.yzh.rfid.app.request.GetDeviceTypeRequest.GetDeviceTypeRequestMessage.Builder.class);
    }

    public static final int SESSION_FIELD_NUMBER = 1;
    private volatile Object session_;
    /**
     * <pre>
     *session
     * </pre>
     *
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
     * <pre>
     *session
     * </pre>
     *
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

    public static final int TYPE_FIELD_NUMBER = 2;
    private volatile Object type_;
    /**
     * <pre>
     *类型
     * </pre>
     *
     * <code>optional string type = 2;</code>
     */
    public String getType() {
      Object ref = type_;
      if (ref instanceof String) {
        return (String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        type_ = s;
        return s;
      }
    }
    /**
     * <pre>
     *类型
     * </pre>
     *
     * <code>optional string type = 2;</code>
     */
    public com.google.protobuf.ByteString
        getTypeBytes() {
      Object ref = type_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        type_ = b;
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
      if (!getTypeBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 2, type_);
      }
    }

    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (!getSessionBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, session_);
      }
      if (!getTypeBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, type_);
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
      if (!(obj instanceof com.yzh.rfid.app.request.GetDeviceTypeRequest.GetDeviceTypeRequestMessage)) {
        return super.equals(obj);
      }
      com.yzh.rfid.app.request.GetDeviceTypeRequest.GetDeviceTypeRequestMessage other = (com.yzh.rfid.app.request.GetDeviceTypeRequest.GetDeviceTypeRequestMessage) obj;

      boolean result = true;
      result = result && getSession()
          .equals(other.getSession());
      result = result && getType()
          .equals(other.getType());
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
      hash = (37 * hash) + TYPE_FIELD_NUMBER;
      hash = (53 * hash) + getType().hashCode();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.yzh.rfid.app.request.GetDeviceTypeRequest.GetDeviceTypeRequestMessage parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.yzh.rfid.app.request.GetDeviceTypeRequest.GetDeviceTypeRequestMessage parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.yzh.rfid.app.request.GetDeviceTypeRequest.GetDeviceTypeRequestMessage parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.yzh.rfid.app.request.GetDeviceTypeRequest.GetDeviceTypeRequestMessage parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.yzh.rfid.app.request.GetDeviceTypeRequest.GetDeviceTypeRequestMessage parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.yzh.rfid.app.request.GetDeviceTypeRequest.GetDeviceTypeRequestMessage parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static com.yzh.rfid.app.request.GetDeviceTypeRequest.GetDeviceTypeRequestMessage parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static com.yzh.rfid.app.request.GetDeviceTypeRequest.GetDeviceTypeRequestMessage parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static com.yzh.rfid.app.request.GetDeviceTypeRequest.GetDeviceTypeRequestMessage parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.yzh.rfid.app.request.GetDeviceTypeRequest.GetDeviceTypeRequestMessage parseFrom(
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
    public static Builder newBuilder(com.yzh.rfid.app.request.GetDeviceTypeRequest.GetDeviceTypeRequestMessage prototype) {
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
     * <pre>
     * [运维App] 获取基站类型
     * </pre>
     *
     * Protobuf type {@code GetDeviceTypeRequestMessage}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:GetDeviceTypeRequestMessage)
        com.yzh.rfid.app.request.GetDeviceTypeRequest.GetDeviceTypeRequestMessageOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return com.yzh.rfid.app.request.GetDeviceTypeRequest.internal_static_GetDeviceTypeRequestMessage_descriptor;
      }

      protected FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.yzh.rfid.app.request.GetDeviceTypeRequest.internal_static_GetDeviceTypeRequestMessage_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.yzh.rfid.app.request.GetDeviceTypeRequest.GetDeviceTypeRequestMessage.class, com.yzh.rfid.app.request.GetDeviceTypeRequest.GetDeviceTypeRequestMessage.Builder.class);
      }

      // Construct using com.yzh.rfid.app.request.GetDeviceTypeRequest.GetDeviceTypeRequestMessage.newBuilder()
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

        type_ = "";

        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return com.yzh.rfid.app.request.GetDeviceTypeRequest.internal_static_GetDeviceTypeRequestMessage_descriptor;
      }

      public com.yzh.rfid.app.request.GetDeviceTypeRequest.GetDeviceTypeRequestMessage getDefaultInstanceForType() {
        return com.yzh.rfid.app.request.GetDeviceTypeRequest.GetDeviceTypeRequestMessage.getDefaultInstance();
      }

      public com.yzh.rfid.app.request.GetDeviceTypeRequest.GetDeviceTypeRequestMessage build() {
        com.yzh.rfid.app.request.GetDeviceTypeRequest.GetDeviceTypeRequestMessage result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public com.yzh.rfid.app.request.GetDeviceTypeRequest.GetDeviceTypeRequestMessage buildPartial() {
        com.yzh.rfid.app.request.GetDeviceTypeRequest.GetDeviceTypeRequestMessage result = new com.yzh.rfid.app.request.GetDeviceTypeRequest.GetDeviceTypeRequestMessage(this);
        result.session_ = session_;
        result.type_ = type_;
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
        if (other instanceof com.yzh.rfid.app.request.GetDeviceTypeRequest.GetDeviceTypeRequestMessage) {
          return mergeFrom((com.yzh.rfid.app.request.GetDeviceTypeRequest.GetDeviceTypeRequestMessage)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.yzh.rfid.app.request.GetDeviceTypeRequest.GetDeviceTypeRequestMessage other) {
        if (other == com.yzh.rfid.app.request.GetDeviceTypeRequest.GetDeviceTypeRequestMessage.getDefaultInstance()) return this;
        if (!other.getSession().isEmpty()) {
          session_ = other.session_;
          onChanged();
        }
        if (!other.getType().isEmpty()) {
          type_ = other.type_;
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
        com.yzh.rfid.app.request.GetDeviceTypeRequest.GetDeviceTypeRequestMessage parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (com.yzh.rfid.app.request.GetDeviceTypeRequest.GetDeviceTypeRequestMessage) e.getUnfinishedMessage();
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
       * <pre>
       *session
       * </pre>
       *
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
       * <pre>
       *session
       * </pre>
       *
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
       * <pre>
       *session
       * </pre>
       *
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
       * <pre>
       *session
       * </pre>
       *
       * <code>optional string session = 1;</code>
       */
      public Builder clearSession() {
        
        session_ = getDefaultInstance().getSession();
        onChanged();
        return this;
      }
      /**
       * <pre>
       *session
       * </pre>
       *
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

      private Object type_ = "";
      /**
       * <pre>
       *类型
       * </pre>
       *
       * <code>optional string type = 2;</code>
       */
      public String getType() {
        Object ref = type_;
        if (!(ref instanceof String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          String s = bs.toStringUtf8();
          type_ = s;
          return s;
        } else {
          return (String) ref;
        }
      }
      /**
       * <pre>
       *类型
       * </pre>
       *
       * <code>optional string type = 2;</code>
       */
      public com.google.protobuf.ByteString
          getTypeBytes() {
        Object ref = type_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (String) ref);
          type_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <pre>
       *类型
       * </pre>
       *
       * <code>optional string type = 2;</code>
       */
      public Builder setType(
          String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        type_ = value;
        onChanged();
        return this;
      }
      /**
       * <pre>
       *类型
       * </pre>
       *
       * <code>optional string type = 2;</code>
       */
      public Builder clearType() {
        
        type_ = getDefaultInstance().getType();
        onChanged();
        return this;
      }
      /**
       * <pre>
       *类型
       * </pre>
       *
       * <code>optional string type = 2;</code>
       */
      public Builder setTypeBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        type_ = value;
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


      // @@protoc_insertion_point(builder_scope:GetDeviceTypeRequestMessage)
    }

    // @@protoc_insertion_point(class_scope:GetDeviceTypeRequestMessage)
    private static final com.yzh.rfid.app.request.GetDeviceTypeRequest.GetDeviceTypeRequestMessage DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new com.yzh.rfid.app.request.GetDeviceTypeRequest.GetDeviceTypeRequestMessage();
    }

    public static com.yzh.rfid.app.request.GetDeviceTypeRequest.GetDeviceTypeRequestMessage getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<GetDeviceTypeRequestMessage>
        PARSER = new com.google.protobuf.AbstractParser<GetDeviceTypeRequestMessage>() {
      public GetDeviceTypeRequestMessage parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
          return new GetDeviceTypeRequestMessage(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<GetDeviceTypeRequestMessage> parser() {
      return PARSER;
    }

    @Override
    public com.google.protobuf.Parser<GetDeviceTypeRequestMessage> getParserForType() {
      return PARSER;
    }

    public com.yzh.rfid.app.request.GetDeviceTypeRequest.GetDeviceTypeRequestMessage getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_GetDeviceTypeRequestMessage_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_GetDeviceTypeRequestMessage_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    String[] descriptorData = {
      "\n\032GetDeviceTypeRequest.proto\"<\n\033GetDevic" +
      "eTypeRequestMessage\022\017\n\007session\030\001 \001(\t\022\014\n\004" +
      "type\030\002 \001(\tB4\n\034com.yzh.rfid.app.reque" +
      "stB\024GetDeviceTypeRequestb\006proto3"
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
    internal_static_GetDeviceTypeRequestMessage_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_GetDeviceTypeRequestMessage_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_GetDeviceTypeRequestMessage_descriptor,
        new String[] { "Session", "Type", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
