include "../struct/PublicStruct.thrift"
namespace java com.alone.thrift.service
service RoleService {
    list<PublicStruct.RoleStruct> roles(1: optional i64 id);
}