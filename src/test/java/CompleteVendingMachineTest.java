import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({IdleStateTest.class, InsertMoneyTest.class, ReadyTest.class, SnackTest.class,
                DispenseHandlerTest.class, VendingMachineTest.class})
public class CompleteVendingMachineTest
{

}
