package little_util.b2c.design;

import org.omg.CORBA.Request;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.ws.rs.core.Response;


/**
 * 责任链模式
 * @Author: liwang
 * Date:     2021/12/23 5:30 PM
 */
public abstract class AbstractHandler {
    //责任链中的下一个对象
    private AbstractHandler nextHandler;

    /**
     * 责任链的下一个对象
     */
    public void setNextHandler(AbstractHandler nextHandler){
        this.nextHandler = nextHandler;
    }

    /**
     * 具体参数拦截逻辑,给子类去实现
     */
    public void filter(Request request, Response response) {
        doFilter(request, response);
        if (getNextHandler() != null) {
            getNextHandler().filter(request, response);
        }
    }

    public AbstractHandler getNextHandler() {
        return nextHandler;
    }

    abstract void doFilter(Request filterRequest, Response response);

    /**
     * 参数校验对象
     **/
    @Component
    @Order(1) //顺序排第1，最先校验
    public class CheckParamFilterObject extends AbstractHandler {

        @Override
        public void doFilter(Request request, Response response) {
            System.out.println("非空参数检查");
        }
    }

    /**
     *  安全校验对象
     */
    @Component
    @Order(2) //校验顺序排第2
    public class CheckSecurityFilterObject extends AbstractHandler {

        @Override
        public void doFilter(Request request, Response response) {
            //invoke Security check
            System.out.println("安全调用校验");
        }
    }
    /**
     *  黑名单校验对象
     */
    @Component
    @Order(3) //校验顺序排第3
    public class CheckBlackFilterObject extends AbstractHandler {

        @Override
        public void doFilter(Request request, Response response) {
            //invoke black list check
            System.out.println("校验黑名单");
        }
    }

    /**
     *  规则拦截对象
     */
    @Component
    @Order(4) //校验顺序排第4
    public class CheckRuleFilterObject extends AbstractHandler {

        @Override
        public void doFilter(Request request, Response response) {
            //check rule
            System.out.println("check rule");
        }
    }
}
