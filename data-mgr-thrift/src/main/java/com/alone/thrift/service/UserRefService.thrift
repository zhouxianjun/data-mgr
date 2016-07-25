include "../struct/PublicStruct.thrift"
namespace java com.alone.thrift.service
service UserRefService {
    bool setRef(1: i64 user, 2: list<i64> refs, 3: i32 type) throws (1: PublicStruct.InvalidOperation ex);

    bool setRefs(1: i64 user, 2: list<i64> box, 3: list<i64> app_package, 4: list<i64> require_package, 5: list<i64> app_white, 6: list<i64> install_active) throws (1: PublicStruct.InvalidOperation ex);
}
