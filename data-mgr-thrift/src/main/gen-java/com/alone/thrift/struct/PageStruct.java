/**
 * Autogenerated by Thrift Compiler (0.9.3)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.alone.thrift.struct;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.server.AbstractNonblockingServer.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import javax.annotation.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked"})
@Generated(value = "Autogenerated by Thrift Compiler (0.9.3)", date = "2016-08-04")
public class PageStruct implements org.apache.thrift.TBase<PageStruct, PageStruct._Fields>, java.io.Serializable, Cloneable, Comparable<PageStruct> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("PageStruct");

  private static final org.apache.thrift.protocol.TField PAGE_NUM_FIELD_DESC = new org.apache.thrift.protocol.TField("pageNum", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField PAGE_SIZE_FIELD_DESC = new org.apache.thrift.protocol.TField("pageSize", org.apache.thrift.protocol.TType.I32, (short)2);
  private static final org.apache.thrift.protocol.TField COUNT_FIELD_DESC = new org.apache.thrift.protocol.TField("count", org.apache.thrift.protocol.TType.I32, (short)3);
  private static final org.apache.thrift.protocol.TField CURRENT_FIELD_DESC = new org.apache.thrift.protocol.TField("current", org.apache.thrift.protocol.TType.I32, (short)4);
  private static final org.apache.thrift.protocol.TField ITEMS_FIELD_DESC = new org.apache.thrift.protocol.TField("items", org.apache.thrift.protocol.TType.STRING, (short)5);
  private static final org.apache.thrift.protocol.TField QUERY_FIELD_DESC = new org.apache.thrift.protocol.TField("query", org.apache.thrift.protocol.TType.MAP, (short)6);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new PageStructStandardSchemeFactory());
    schemes.put(TupleScheme.class, new PageStructTupleSchemeFactory());
  }

  private int pageNum; // required
  private int pageSize; // required
  private int count; // required
  private int current; // required
  private String items; // required
  private Map<String,String> query; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    PAGE_NUM((short)1, "pageNum"),
    PAGE_SIZE((short)2, "pageSize"),
    COUNT((short)3, "count"),
    CURRENT((short)4, "current"),
    ITEMS((short)5, "items"),
    QUERY((short)6, "query");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // PAGE_NUM
          return PAGE_NUM;
        case 2: // PAGE_SIZE
          return PAGE_SIZE;
        case 3: // COUNT
          return COUNT;
        case 4: // CURRENT
          return CURRENT;
        case 5: // ITEMS
          return ITEMS;
        case 6: // QUERY
          return QUERY;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __PAGENUM_ISSET_ID = 0;
  private static final int __PAGESIZE_ISSET_ID = 1;
  private static final int __COUNT_ISSET_ID = 2;
  private static final int __CURRENT_ISSET_ID = 3;
  private byte __isset_bitfield = 0;
  private static final _Fields optionals[] = {_Fields.QUERY};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.PAGE_NUM, new org.apache.thrift.meta_data.FieldMetaData("pageNum", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.PAGE_SIZE, new org.apache.thrift.meta_data.FieldMetaData("pageSize", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.COUNT, new org.apache.thrift.meta_data.FieldMetaData("count", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.CURRENT, new org.apache.thrift.meta_data.FieldMetaData("current", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.ITEMS, new org.apache.thrift.meta_data.FieldMetaData("items", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.QUERY, new org.apache.thrift.meta_data.FieldMetaData("query", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.MapMetaData(org.apache.thrift.protocol.TType.MAP, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING), 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING))));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(PageStruct.class, metaDataMap);
  }

  public PageStruct() {
  }

  public PageStruct(
    int pageNum,
    int pageSize,
    int count,
    int current,
    String items)
  {
    this();
    this.pageNum = pageNum;
    setPageNumIsSet(true);
    this.pageSize = pageSize;
    setPageSizeIsSet(true);
    this.count = count;
    setCountIsSet(true);
    this.current = current;
    setCurrentIsSet(true);
    this.items = items;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public PageStruct(PageStruct other) {
    __isset_bitfield = other.__isset_bitfield;
    this.pageNum = other.pageNum;
    this.pageSize = other.pageSize;
    this.count = other.count;
    this.current = other.current;
    if (other.isSetItems()) {
      this.items = other.items;
    }
    if (other.isSetQuery()) {
      Map<String,String> __this__query = new HashMap<String,String>(other.query);
      this.query = __this__query;
    }
  }

  public PageStruct deepCopy() {
    return new PageStruct(this);
  }

  @Override
  public void clear() {
    setPageNumIsSet(false);
    this.pageNum = 0;
    setPageSizeIsSet(false);
    this.pageSize = 0;
    setCountIsSet(false);
    this.count = 0;
    setCurrentIsSet(false);
    this.current = 0;
    this.items = null;
    this.query = null;
  }

  public int getPageNum() {
    return this.pageNum;
  }

  public PageStruct setPageNum(int pageNum) {
    this.pageNum = pageNum;
    setPageNumIsSet(true);
    return this;
  }

  public void unsetPageNum() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __PAGENUM_ISSET_ID);
  }

  /** Returns true if field pageNum is set (has been assigned a value) and false otherwise */
  public boolean isSetPageNum() {
    return EncodingUtils.testBit(__isset_bitfield, __PAGENUM_ISSET_ID);
  }

  public void setPageNumIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __PAGENUM_ISSET_ID, value);
  }

  public int getPageSize() {
    return this.pageSize;
  }

  public PageStruct setPageSize(int pageSize) {
    this.pageSize = pageSize;
    setPageSizeIsSet(true);
    return this;
  }

  public void unsetPageSize() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __PAGESIZE_ISSET_ID);
  }

  /** Returns true if field pageSize is set (has been assigned a value) and false otherwise */
  public boolean isSetPageSize() {
    return EncodingUtils.testBit(__isset_bitfield, __PAGESIZE_ISSET_ID);
  }

  public void setPageSizeIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __PAGESIZE_ISSET_ID, value);
  }

  public int getCount() {
    return this.count;
  }

  public PageStruct setCount(int count) {
    this.count = count;
    setCountIsSet(true);
    return this;
  }

  public void unsetCount() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __COUNT_ISSET_ID);
  }

  /** Returns true if field count is set (has been assigned a value) and false otherwise */
  public boolean isSetCount() {
    return EncodingUtils.testBit(__isset_bitfield, __COUNT_ISSET_ID);
  }

  public void setCountIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __COUNT_ISSET_ID, value);
  }

  public int getCurrent() {
    return this.current;
  }

  public PageStruct setCurrent(int current) {
    this.current = current;
    setCurrentIsSet(true);
    return this;
  }

  public void unsetCurrent() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __CURRENT_ISSET_ID);
  }

  /** Returns true if field current is set (has been assigned a value) and false otherwise */
  public boolean isSetCurrent() {
    return EncodingUtils.testBit(__isset_bitfield, __CURRENT_ISSET_ID);
  }

  public void setCurrentIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __CURRENT_ISSET_ID, value);
  }

  public String getItems() {
    return this.items;
  }

  public PageStruct setItems(String items) {
    this.items = items;
    return this;
  }

  public void unsetItems() {
    this.items = null;
  }

  /** Returns true if field items is set (has been assigned a value) and false otherwise */
  public boolean isSetItems() {
    return this.items != null;
  }

  public void setItemsIsSet(boolean value) {
    if (!value) {
      this.items = null;
    }
  }

  public int getQuerySize() {
    return (this.query == null) ? 0 : this.query.size();
  }

  public void putToQuery(String key, String val) {
    if (this.query == null) {
      this.query = new HashMap<String,String>();
    }
    this.query.put(key, val);
  }

  public Map<String,String> getQuery() {
    return this.query;
  }

  public PageStruct setQuery(Map<String,String> query) {
    this.query = query;
    return this;
  }

  public void unsetQuery() {
    this.query = null;
  }

  /** Returns true if field query is set (has been assigned a value) and false otherwise */
  public boolean isSetQuery() {
    return this.query != null;
  }

  public void setQueryIsSet(boolean value) {
    if (!value) {
      this.query = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case PAGE_NUM:
      if (value == null) {
        unsetPageNum();
      } else {
        setPageNum((Integer)value);
      }
      break;

    case PAGE_SIZE:
      if (value == null) {
        unsetPageSize();
      } else {
        setPageSize((Integer)value);
      }
      break;

    case COUNT:
      if (value == null) {
        unsetCount();
      } else {
        setCount((Integer)value);
      }
      break;

    case CURRENT:
      if (value == null) {
        unsetCurrent();
      } else {
        setCurrent((Integer)value);
      }
      break;

    case ITEMS:
      if (value == null) {
        unsetItems();
      } else {
        setItems((String)value);
      }
      break;

    case QUERY:
      if (value == null) {
        unsetQuery();
      } else {
        setQuery((Map<String,String>)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case PAGE_NUM:
      return getPageNum();

    case PAGE_SIZE:
      return getPageSize();

    case COUNT:
      return getCount();

    case CURRENT:
      return getCurrent();

    case ITEMS:
      return getItems();

    case QUERY:
      return getQuery();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case PAGE_NUM:
      return isSetPageNum();
    case PAGE_SIZE:
      return isSetPageSize();
    case COUNT:
      return isSetCount();
    case CURRENT:
      return isSetCurrent();
    case ITEMS:
      return isSetItems();
    case QUERY:
      return isSetQuery();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof PageStruct)
      return this.equals((PageStruct)that);
    return false;
  }

  public boolean equals(PageStruct that) {
    if (that == null)
      return false;

    boolean this_present_pageNum = true;
    boolean that_present_pageNum = true;
    if (this_present_pageNum || that_present_pageNum) {
      if (!(this_present_pageNum && that_present_pageNum))
        return false;
      if (this.pageNum != that.pageNum)
        return false;
    }

    boolean this_present_pageSize = true;
    boolean that_present_pageSize = true;
    if (this_present_pageSize || that_present_pageSize) {
      if (!(this_present_pageSize && that_present_pageSize))
        return false;
      if (this.pageSize != that.pageSize)
        return false;
    }

    boolean this_present_count = true;
    boolean that_present_count = true;
    if (this_present_count || that_present_count) {
      if (!(this_present_count && that_present_count))
        return false;
      if (this.count != that.count)
        return false;
    }

    boolean this_present_current = true;
    boolean that_present_current = true;
    if (this_present_current || that_present_current) {
      if (!(this_present_current && that_present_current))
        return false;
      if (this.current != that.current)
        return false;
    }

    boolean this_present_items = true && this.isSetItems();
    boolean that_present_items = true && that.isSetItems();
    if (this_present_items || that_present_items) {
      if (!(this_present_items && that_present_items))
        return false;
      if (!this.items.equals(that.items))
        return false;
    }

    boolean this_present_query = true && this.isSetQuery();
    boolean that_present_query = true && that.isSetQuery();
    if (this_present_query || that_present_query) {
      if (!(this_present_query && that_present_query))
        return false;
      if (!this.query.equals(that.query))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_pageNum = true;
    list.add(present_pageNum);
    if (present_pageNum)
      list.add(pageNum);

    boolean present_pageSize = true;
    list.add(present_pageSize);
    if (present_pageSize)
      list.add(pageSize);

    boolean present_count = true;
    list.add(present_count);
    if (present_count)
      list.add(count);

    boolean present_current = true;
    list.add(present_current);
    if (present_current)
      list.add(current);

    boolean present_items = true && (isSetItems());
    list.add(present_items);
    if (present_items)
      list.add(items);

    boolean present_query = true && (isSetQuery());
    list.add(present_query);
    if (present_query)
      list.add(query);

    return list.hashCode();
  }

  @Override
  public int compareTo(PageStruct other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetPageNum()).compareTo(other.isSetPageNum());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPageNum()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.pageNum, other.pageNum);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetPageSize()).compareTo(other.isSetPageSize());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPageSize()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.pageSize, other.pageSize);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetCount()).compareTo(other.isSetCount());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCount()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.count, other.count);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetCurrent()).compareTo(other.isSetCurrent());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCurrent()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.current, other.current);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetItems()).compareTo(other.isSetItems());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetItems()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.items, other.items);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetQuery()).compareTo(other.isSetQuery());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetQuery()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.query, other.query);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("PageStruct(");
    boolean first = true;

    sb.append("pageNum:");
    sb.append(this.pageNum);
    first = false;
    if (!first) sb.append(", ");
    sb.append("pageSize:");
    sb.append(this.pageSize);
    first = false;
    if (!first) sb.append(", ");
    sb.append("count:");
    sb.append(this.count);
    first = false;
    if (!first) sb.append(", ");
    sb.append("current:");
    sb.append(this.current);
    first = false;
    if (!first) sb.append(", ");
    sb.append("items:");
    if (this.items == null) {
      sb.append("null");
    } else {
      sb.append(this.items);
    }
    first = false;
    if (isSetQuery()) {
      if (!first) sb.append(", ");
      sb.append("query:");
      if (this.query == null) {
        sb.append("null");
      } else {
        sb.append(this.query);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class PageStructStandardSchemeFactory implements SchemeFactory {
    public PageStructStandardScheme getScheme() {
      return new PageStructStandardScheme();
    }
  }

  private static class PageStructStandardScheme extends StandardScheme<PageStruct> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, PageStruct struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // PAGE_NUM
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.pageNum = iprot.readI32();
              struct.setPageNumIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // PAGE_SIZE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.pageSize = iprot.readI32();
              struct.setPageSizeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // COUNT
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.count = iprot.readI32();
              struct.setCountIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // CURRENT
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.current = iprot.readI32();
              struct.setCurrentIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // ITEMS
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.items = iprot.readString();
              struct.setItemsIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 6: // QUERY
            if (schemeField.type == org.apache.thrift.protocol.TType.MAP) {
              {
                org.apache.thrift.protocol.TMap _map10 = iprot.readMapBegin();
                struct.query = new HashMap<String,String>(2*_map10.size);
                String _key11;
                String _val12;
                for (int _i13 = 0; _i13 < _map10.size; ++_i13)
                {
                  _key11 = iprot.readString();
                  _val12 = iprot.readString();
                  struct.query.put(_key11, _val12);
                }
                iprot.readMapEnd();
              }
              struct.setQueryIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, PageStruct struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(PAGE_NUM_FIELD_DESC);
      oprot.writeI32(struct.pageNum);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(PAGE_SIZE_FIELD_DESC);
      oprot.writeI32(struct.pageSize);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(COUNT_FIELD_DESC);
      oprot.writeI32(struct.count);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(CURRENT_FIELD_DESC);
      oprot.writeI32(struct.current);
      oprot.writeFieldEnd();
      if (struct.items != null) {
        oprot.writeFieldBegin(ITEMS_FIELD_DESC);
        oprot.writeString(struct.items);
        oprot.writeFieldEnd();
      }
      if (struct.query != null) {
        if (struct.isSetQuery()) {
          oprot.writeFieldBegin(QUERY_FIELD_DESC);
          {
            oprot.writeMapBegin(new org.apache.thrift.protocol.TMap(org.apache.thrift.protocol.TType.STRING, org.apache.thrift.protocol.TType.STRING, struct.query.size()));
            for (Map.Entry<String, String> _iter14 : struct.query.entrySet())
            {
              oprot.writeString(_iter14.getKey());
              oprot.writeString(_iter14.getValue());
            }
            oprot.writeMapEnd();
          }
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class PageStructTupleSchemeFactory implements SchemeFactory {
    public PageStructTupleScheme getScheme() {
      return new PageStructTupleScheme();
    }
  }

  private static class PageStructTupleScheme extends TupleScheme<PageStruct> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, PageStruct struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetPageNum()) {
        optionals.set(0);
      }
      if (struct.isSetPageSize()) {
        optionals.set(1);
      }
      if (struct.isSetCount()) {
        optionals.set(2);
      }
      if (struct.isSetCurrent()) {
        optionals.set(3);
      }
      if (struct.isSetItems()) {
        optionals.set(4);
      }
      if (struct.isSetQuery()) {
        optionals.set(5);
      }
      oprot.writeBitSet(optionals, 6);
      if (struct.isSetPageNum()) {
        oprot.writeI32(struct.pageNum);
      }
      if (struct.isSetPageSize()) {
        oprot.writeI32(struct.pageSize);
      }
      if (struct.isSetCount()) {
        oprot.writeI32(struct.count);
      }
      if (struct.isSetCurrent()) {
        oprot.writeI32(struct.current);
      }
      if (struct.isSetItems()) {
        oprot.writeString(struct.items);
      }
      if (struct.isSetQuery()) {
        {
          oprot.writeI32(struct.query.size());
          for (Map.Entry<String, String> _iter15 : struct.query.entrySet())
          {
            oprot.writeString(_iter15.getKey());
            oprot.writeString(_iter15.getValue());
          }
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, PageStruct struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(6);
      if (incoming.get(0)) {
        struct.pageNum = iprot.readI32();
        struct.setPageNumIsSet(true);
      }
      if (incoming.get(1)) {
        struct.pageSize = iprot.readI32();
        struct.setPageSizeIsSet(true);
      }
      if (incoming.get(2)) {
        struct.count = iprot.readI32();
        struct.setCountIsSet(true);
      }
      if (incoming.get(3)) {
        struct.current = iprot.readI32();
        struct.setCurrentIsSet(true);
      }
      if (incoming.get(4)) {
        struct.items = iprot.readString();
        struct.setItemsIsSet(true);
      }
      if (incoming.get(5)) {
        {
          org.apache.thrift.protocol.TMap _map16 = new org.apache.thrift.protocol.TMap(org.apache.thrift.protocol.TType.STRING, org.apache.thrift.protocol.TType.STRING, iprot.readI32());
          struct.query = new HashMap<String,String>(2*_map16.size);
          String _key17;
          String _val18;
          for (int _i19 = 0; _i19 < _map16.size; ++_i19)
          {
            _key17 = iprot.readString();
            _val18 = iprot.readString();
            struct.query.put(_key17, _val18);
          }
        }
        struct.setQueryIsSet(true);
      }
    }
  }

}

