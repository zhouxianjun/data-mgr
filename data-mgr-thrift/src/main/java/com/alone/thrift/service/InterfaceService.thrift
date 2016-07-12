include "../struct/PublicStruct.thrift"
namespace java com.alone.thrift.service
service InterfaceService {
    list<PublicStruct.InterfaceStruct> interfaces() throws (1: PublicStruct.InvalidOperation ex);

    list<PublicStruct.InterfaceStruct> interfacesByUser(1: i64 user) throws (1: PublicStruct.InvalidOperation ex);

    list<PublicStruct.InterfaceStruct> interfacesBySetMenu(1: i64 user, 2: i64 menu) throws (1: PublicStruct.InvalidOperation ex);

    i64 add(1: PublicStruct.InterfaceStruct bean) throws (1: PublicStruct.InvalidOperation ex);

    bool update(1: PublicStruct.InterfaceStruct bean) throws (1: PublicStruct.InvalidOperation ex);
}