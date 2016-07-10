include "../struct/PublicStruct.thrift"
namespace java com.alone.thrift.service
service MenuService {
    list<PublicStruct.MenuStruct> menus() throws (1: PublicStruct.InvalidOperation ex);

    list<PublicStruct.MenuStruct> menusByUser(1: i64 user) throws (1: PublicStruct.InvalidOperation ex);

    i64 add(1: PublicStruct.MenuStruct menu) throws (1: PublicStruct.InvalidOperation ex);

    bool update(1: PublicStruct.MenuStruct menu) throws (1: PublicStruct.InvalidOperation ex);

    bool delMenu(1: i64 id) throws (1: PublicStruct.InvalidOperation ex);
}