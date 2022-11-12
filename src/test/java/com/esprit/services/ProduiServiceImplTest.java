package com.esprit.services;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import com.esprit.examen.entities.Produit;
import com.esprit.examen.repositories.ProduitRepository;
import com.esprit.examen.services.ProduitServiceImpl;
import com.mysql.fabric.xmlrpc.base.Data;
import com.mysql.jdbc.log.Log;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class ProduiServiceImplTest {


    @Mock
    ProduitRepository produitRepository ;
    @InjectMocks
    ProduitServiceImpl produitServiceImpl;

    Produit p =  new Produit(1L,"Ac12", "Produit1", 4, new Date(), new Date());
    Produit p1 = new Produit(2L,"Ac13", "Produit2", 5, new Date(), new Date());
    Produit p2 = new Produit(3L,"Ac14", "Produit3", 7, new Date(), new Date());
    
    List<Produit> listProduits = new ArrayList<Produit>() {
        {
            add(p);
            add(p1);
            add(p2);
        }
    };

    @Test
    public void testretrieveAllProduits() {
        Mockito.when(produitRepository.findAll()).thenReturn(listProduits);
        List<Produit> listprod = produitServiceImpl.retrieveAllProduits();
        assertEquals(3, listprod.size());
        
    }


    @Test
    public void testaddProduit(){
        Mockito.when(produitRepository.save(p)).thenReturn(p);
        Produit prod = produitServiceImpl.addProduit(p);
        Mockito.verify(produitRepository, times(1)).save(Mockito.any(Produit.class));
        
    }

    @Test
    public void testupdateProduit(){
        Mockito.when(produitRepository.save(p)).thenReturn(p);
        Produit prod = produitServiceImpl.updateProduit(p);
        Mockito.verify(produitRepository, times(1)).save(Mockito.any(Produit.class));
    }

    @Test
    public void testdeleteProduit(){
        produitServiceImpl.deleteProduit(1L);
        Mockito.verify(produitRepository, times(1)).deleteById(1L);
    }

    
    @Test
    public void testretrieveProduits() {
        Mockito.when(produitRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(p));
        Produit prod =produitServiceImpl.retrieveProduit(2L);
        assertNotNull(prod);
    }
}
