package little_util.b2c;



@SpringBootApplication
@MapperScan("com.taiyuan.work.fitment.b2c.mapper")
@EnableAspectJAutoProxy
public class B2cBootstrap {
    public static void main(String[] args) {
        new SpringApplicationBuilder(B2cBootstrap.class).run(args);    }
}
