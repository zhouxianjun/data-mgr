include "../struct/PublicStruct.thrift"
namespace java com.alone.thrift.service
service RoleService {
    list<PublicStruct.RoleStruct> roles() throws (1: PublicStruct.InvalidOperation ex);

    list<PublicStruct.RoleStruct> rolesByUser(1: i64 user) throws (1: PublicStruct.InvalidOperation ex);

    list<PublicStruct.RoleStruct> rolesBySetUser(1: i64 user, 2: i64 parent) throws (1: PublicStruct.InvalidOperation ex);

    i64 add(1: string name, 2: i64 pid) throws (1: PublicStruct.InvalidOperation ex);

    bool update(1: i64 id, 2: string name, 3: bool status, 4: i64 pid) throws (1: PublicStruct.InvalidOperation ex);

    bool updateStatus(1: list<i64> ids, 2: bool status) throws (1: PublicStruct.InvalidOperation ex);

    bool setMenus(1: i64 role, 2: i64 user, 3: list<i64> menus) throws (1: PublicStruct.InvalidOperation ex);
}