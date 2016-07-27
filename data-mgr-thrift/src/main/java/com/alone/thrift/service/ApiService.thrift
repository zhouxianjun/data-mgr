include "../struct/PublicStruct.thrift"
namespace java com.alone.thrift.service
service ApiService {
    i64 boxLogin(1: string username, 2: string password, 3: string box_id) throws (1: PublicStruct.InvalidOperation ex);

    string checkBoxVersion(1: string box_id, 2: i32 version_code) throws (1: PublicStruct.InvalidOperation ex);

    string getBoxResourcesList(1: i64 user, 2: string url) throws (1: PublicStruct.InvalidOperation ex);

    bool uploadBrush(1: string box_id, 2: string data, 3: i64 user, 4: string ip) throws (1: PublicStruct.InvalidOperation ex);
}
