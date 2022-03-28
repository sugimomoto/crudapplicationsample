package sugimomoto.crudapplicationsample.config;

import org.springframework.boot.*;
import org.springframework.stereotype.Component;

import sugimomoto.crudapplicationsample.model.*;
import sugimomoto.crudapplicationsample.repostitory.*;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class Dataloader implements ApplicationRunner {
    
    private final DepartmentRepository repositoy;

    @Override
    public void run(ApplicationArguments args) throws Exception{
        var sales = new Department();
        sales.setName("営業");
        repositoy.save(sales);

        var development = new Department();
        development.setName("開発");
        repositoy.save(development);
    }
}
