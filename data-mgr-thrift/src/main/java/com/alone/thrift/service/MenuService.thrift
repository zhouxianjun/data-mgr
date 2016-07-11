include "../struct/PublicStruct.thrift"
namespace java com.alone.thrift.service
service MenuService {
    list<PublicStruct.MenuStruct> menus() throws (1: PublicStruct.InvalidOperation ex);

    list<PublicStruct.MenuStruct> menusByUser(1: i64 user) throws (1: PublicStruct.InvalidOperation ex);

    list<PublicStruct.MenuStruct> menusBySetRole(1: i64 user, 2: i64 role) throws (1: PublicStruct.InvalidOperation ex);

    i64 add(1: PublicStruct.MenuStruct menu) throws (1: PublicStruct.InvalidOperation ex);

    bool update(1: PublicStruct.MenuStruct menu) throws (1: PublicStruct.InvalidOperation ex);

    bool delMenu(1: i64 id) throws (1: PublicStruct.InvalidOperation ex);

    bool setInterfaces(1: i64 menu, 2: i64 user, 3: list<i64> interfaces) throws (1: PublicStruct.InvalidOperation ex);
}