import com.example.lab2.model.DisciplineContainer
import com.example.lab2.model.IContainer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AppConfig {
    @Bean
    fun disciplineContainer(): IContainer<Discipline> {
        return DisciplineContainer()
    }
}
