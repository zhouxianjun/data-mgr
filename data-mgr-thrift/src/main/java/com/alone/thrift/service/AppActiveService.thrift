include "../struct/PublicStruct.thrift"
namespace java com.alone.thrift.service
service AppActiveService {
    i64 add(1: PublicStruct.AppActiveStruct bean) throws (1: PublicStruct.InvalidOperation ex);

    bool update(1: PublicStruct.AppActiveStruct bean) throws (1: PublicStruct.InvalidOperation ex);

    bool remove(1: i64 id) throws (1: PublicStruct.InvalidOperation ex);

    PublicStruct.PageStruct listByPage(1: PublicStruct.PageParamStruct page) throws (1: PublicStruct.InvalidOperation ex);
}
