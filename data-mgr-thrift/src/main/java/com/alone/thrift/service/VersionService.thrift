include "../struct/PublicStruct.thrift"
namespace java com.alone.thrift.service
service VersionService {
    i64 add(1: PublicStruct.VersionStruct bean) throws (1: PublicStruct.InvalidOperation ex);

    PublicStruct.VersionStruct get(1: i64 id) throws (1: PublicStruct.InvalidOperation ex);
}
