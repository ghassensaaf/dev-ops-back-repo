import com.esprit.examen.entities.Reglement;
import com.esprit.examen.repositories.ReglementRepository;
import com.esprit.examen.services.ReglementServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertNotNull;

@SpringBootTest(classes = ReglementServiceImplTest.class)
@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
class ReglementServiceImplTest {

    ReglementRepository reglementRepository = Mockito.mock(ReglementRepository.class);

    @InjectMocks
    ReglementServiceImpl reglementService;

    Reglement op = Reglement.builder().dateReglement(new Date()).idReglement(0L).payee(true).montantPaye(12).montantRestant(3).build();

    List<Reglement> operateurs = new ArrayList<Reglement>() {
        {
            add(Reglement.builder().dateReglement(new Date()).idReglement(6L).payee(true).montantPaye(12).montantRestant(3).build());
            add(Reglement.builder().dateReglement(new Date()).idReglement(1L).payee(true).montantPaye(12).montantRestant(3).build());
            add(Reglement.builder().dateReglement(new Date()).idReglement(2L).payee(true).montantPaye(12).montantRestant(3).build());
            add(Reglement.builder().dateReglement(new Date()).idReglement(3L).payee(true).montantPaye(12).montantRestant(3).build());
            add(Reglement.builder().dateReglement(new Date()).idReglement(4L).payee(true).montantPaye(12).montantRestant(3).build());
            add(Reglement.builder().dateReglement(new Date()).idReglement(5L).payee(true).montantPaye(12).montantRestant(3).build());
        }
    };

    @Test
    void getReglement() {
        Mockito.when(reglementRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(this.op));
        Reglement ope = reglementService.retrieveReglement((long) 2);
        assertNotNull(ope);
        Mockito.verify(reglementRepository).findById(Mockito.anyLong());
    }

    @Test
    void addReglement() {
        Reglement op = Reglement.builder().dateReglement(new Date()).idReglement(0L).payee(true).montantPaye(12).montantRestant(3).build();
        Mockito.when(reglementRepository.save(op)).thenReturn(op);
        Reglement oyp = reglementService.addReglement(op);
        assertNotNull(oyp);
        Mockito.verify(reglementRepository).save(op);
    }
}