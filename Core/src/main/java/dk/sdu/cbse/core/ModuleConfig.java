package dk.sdu.cbse.core;

import dk.sdu.cbse.common.services.IEntityService;
import dk.sdu.cbse.common.services.IGameService;
import dk.sdu.cbse.common.services.IPostService;
import java.util.List;
import java.util.ServiceLoader;
import static java.util.stream.Collectors.toList;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class ModuleConfig {
    public ModuleConfig(){

    }
    @Bean
    public Game game(){
        return new Game(gameServices(),entityServiceList(),postEntityServices());
    }
    @Bean
    public List<IEntityService> entityServiceList(){
        return ServiceLoader.load(IEntityService.class).stream().map(ServiceLoader.Provider::get).collect(toList());
    }

    @Bean
    public List<IGameService> gameServices() {
        return ServiceLoader.load(IGameService.class).stream().map(ServiceLoader.Provider::get).collect(toList());
    }

    @Bean
    public List<IPostService> postEntityServices() {
        return ServiceLoader.load(IPostService.class).stream().map(ServiceLoader.Provider::get).collect(toList());
    }
}
