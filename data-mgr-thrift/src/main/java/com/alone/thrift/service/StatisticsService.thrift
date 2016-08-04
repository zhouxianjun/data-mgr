include "../struct/PublicStruct.thrift"
namespace java com.alone.thrift.service
service StatisticsService {
    string getStaticIndexByDateForSuper(
            1: i64 user, 2: i64 startDate,
            3: i64 endDate, 4: i64 province,
            5: i64 city, 6: string sortName
            7: string sortDir
        ) throws (1: PublicStruct.InvalidOperation ex);

    string getStaticIndexByDateForAdmin(
            1: i64 user, 2: i64 startDate,
            3: i64 endDate, 4: i64 province,
            5: i64 city, 6: string sortName
            7: string sortDir
        ) throws (1: PublicStruct.InvalidOperation ex);

    string getStaticIndexByDate(
        1: i64 user, 2: i64 startDate,
            3: i64 endDate, 4: i64 province,
            5: i64 city, 6: string sortName
            7: string sortDir
        ) throws (1: PublicStruct.InvalidOperation ex);
}
