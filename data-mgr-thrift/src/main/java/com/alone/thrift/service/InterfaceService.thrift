include "../struct/PublicStruct.thrift"
namespace java com.alone.thrift.service
service InterfaceService {
    list<PublicStruct.InterfaceStruct> interfaces() throws (1: PublicStruct.InvalidOperation ex);

    list<PublicStruct.InterfaceStruct> interfacesByUser() throws (1: PublicStruct.InvalidOperation ex);

    list<PublicStruct.InterfaceStruct> interfacesBySetMenu() throws (1: PublicStruct.InvalidOperation ex);

    i64 add(1: PublicStruct.InterfaceStruct bean) throws (1: PublicStruct.InvalidOperation ex);

    bool update(1: PublicStruct.InterfaceStruct bean) throws (1: PublicStruct.InvalidOperation ex);
}