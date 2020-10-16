import java.text.DateFormatSymbols;
import java.time.YearMonth;

public class GroupMonth {
    private YearMonth monthStart;
    private YearMonth monthEnd;

    public GroupMonth(YearMonth monthStart, YearMonth monthEnd) {
        this.monthStart = monthStart;
        this.monthEnd = monthEnd;
    }

    public YearMonth getMonthStart() {
        return monthStart;
    }

    public void setMonthStart(YearMonth monthStart) {
        this.monthStart = monthStart;
    }

    public YearMonth getMonthEnd() {
        return monthEnd;
    }

    public void setMonthEnd(YearMonth monthEnd) {
        this.monthEnd = monthEnd;
    }
}
