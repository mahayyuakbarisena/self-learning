import java.time.LocalDate;
import java.time.YearMonth;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class MainApplication {
    public static void main(String[] args) {
        LocalDate dateStart = LocalDate.parse("2019-03-01");
        LocalDate dateEnd = LocalDate.parse("2020-10-12");
        Long periode = 12L;
        Long diff =  ChronoUnit.MONTHS.between(dateStart, dateEnd);
        Long sisa = diff % periode;
        Long interval = diff / periode;
        List<GroupMonth> groupMonths = new ArrayList<>();
        LocalDate groupDate = dateStart;
        for (int i = 0; i < interval; i++) {
            groupMonths.add(new GroupMonth(YearMonth.from(groupDate), YearMonth.from(groupDate.plusMonths(periode-1L))));
            groupDate = groupDate.plusMonths(periode);
        }
        if (sisa != 0) {
            groupMonths.add(new GroupMonth(YearMonth.from(groupDate), YearMonth.from(groupDate.plusMonths(sisa))));
        }
        for (GroupMonth a: groupMonths
             ) {
            System.out.println("Bulan Mulai: " + a.getMonthStart());
            System.out.println("Bulan Akhir: " + a.getMonthEnd());
            System.out.println();
        }
    }
}
