include "../struct/PublicStruct.thrift"
namespace java com.alone.thrift.service
service UserService {
    list<PublicStruct.UserStruct> users() throws (1: PublicStruct.InvalidOperation ex);

    list<PublicStruct.UserStruct> usersByUser() throws (1: PublicStruct.InvalidOperation ex);

    i64 add(1: PublicStruct.UserStruct bean) throws (1: PublicStruct.InvalidOperation ex);

    bool update(1: PublicStruct.UserStruct bean) throws (1: PublicStruct.InvalidOperation ex);

    bool setRoles(1: i64 user, 2: i64 parent, 3: list<i64> roles) throws (1: PublicStruct.InvalidOperation ex);

    bool login(1: string username, 2: string password) throws (1: PublicStruct.InvalidOperation ex);
}