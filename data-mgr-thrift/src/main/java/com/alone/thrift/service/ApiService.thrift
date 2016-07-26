include "../struct/PublicStruct.thrift"
namespace java com.alone.thrift.service
service ApiService {
    bool boxLogin(1: string username, 2: string password, 3: string box_id) throws (1: PublicStruct.InvalidOperation ex);

    string checkBoxVersion(1: string box_id, 2: i32 version_code) throws (1: PublicStruct.InvalidOperation ex);

    string getBoxResourcesList(1: i64 user) throws (1: PublicStruct.InvalidOperation ex);

    string uploadBrush(1: string box_id, 2: string data) throws (1: PublicStruct.InvalidOperation ex);
}
