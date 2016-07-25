include "../struct/PublicStruct.thrift"
namespace java com.alone.thrift.service
service InstallActiveService {
    i64 add(1: PublicStruct.InstallActiveStruct bean) throws (1: PublicStruct.InvalidOperation ex);

    bool update(1: PublicStruct.InstallActiveStruct bean) throws (1: PublicStruct.InvalidOperation ex);

    bool remove(1: i64 id) throws (1: PublicStruct.InvalidOperation ex);

    PublicStruct.PageStruct listByPage(1: PublicStruct.PageParamStruct page) throws (1: PublicStruct.InvalidOperation ex);

    string allList(1: i64 user) throws (1: PublicStruct.InvalidOperation ex);
}
