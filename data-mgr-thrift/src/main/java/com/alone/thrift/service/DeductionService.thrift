include "../struct/PublicStruct.thrift"
namespace java com.alone.thrift.service
service DeductionService {
    i64 add(1: PublicStruct.DeductionStruct bean, 2: list<i64> apps) throws (1: PublicStruct.InvalidOperation ex);

    bool update(1: PublicStruct.DeductionStruct bean, 3: list<i64> apps) throws (1: PublicStruct.InvalidOperation ex);

    bool setUsers(1: i64 id, 2: list<i64> users);

    bool remove(1: i64 id) throws (1: PublicStruct.InvalidOperation ex);

    PublicStruct.PageStruct listByPage(1: PublicStruct.PageParamStruct page) throws (1: PublicStruct.InvalidOperation ex);

    string getUsers(1: i64 id) throws (1: PublicStruct.InvalidOperation ex);

    string getApps(1: i64 id) throws (1: PublicStruct.InvalidOperation ex);
}
