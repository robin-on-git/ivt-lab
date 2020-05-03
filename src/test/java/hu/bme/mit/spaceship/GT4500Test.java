package hu.bme.mit.spaceship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class GT4500Test {

  private GT4500 ship;
  private TorpedoStore mockP;
  private TorpedoStore mockS;

  @BeforeEach
  public void init(){
    mockP = mock(TorpedoStore.class);
    mockS = mock(TorpedoStore.class);
    this.ship = new GT4500(mockP, mockS);
  }

  @Test
  public void fireTorpedo_Single_Success(){
    // Arrange
    when(mockP.isEmpty()).thenReturn(false);
    when(mockP.fire(1)).thenReturn(true);

    // Act
    boolean result = ship.fireTorpedo(FiringMode.SINGLE);

    // Assert
    assertEquals(true, result);
    verify(mockP, times(1)).isEmpty();
    verify(mockP, times(1)).fire(1);
  }

  @Test
  public void fireTorpedo_All_Success(){
    // Arrange
    when(mockP.isEmpty()).thenReturn(false);
    when(mockP.fire(1)).thenReturn(true);
    when(mockS.isEmpty()).thenReturn(false);
    when(mockS.fire(1)).thenReturn(true);

    // Act
    boolean result = ship.fireTorpedo(FiringMode.ALL);

    // Assert
    assertEquals(true, result);
    verify(mockP, times(1)).isEmpty();
    verify(mockP, times(1)).fire(1);
    verify(mockS, times(1)).isEmpty();
    verify(mockS, times(1)).fire(1);
  }

  //New tests

  @Test
  public void first_Fires_First() {
    when(mockP.isEmpty()).thenReturn(false);
    when(mockS.isEmpty()).thenReturn(false);

    ship.fireTorpedo(FiringMode.SINGLE);

    verify(mockP, times(1)).fire(1);
    verify(mockS, never()).fire(1);

  }

  @Test
  public void fires_Alternate() {

    when(mockP.isEmpty()).thenReturn(false);
    when(mockS.isEmpty()).thenReturn(false);

    ship.fireTorpedo(FiringMode.SINGLE);

    verify(mockP, times(1)).fire(1);

    ship.fireTorpedo(FiringMode.SINGLE);

    verify(mockS, times(1)).fire(1);

    ship.fireTorpedo(FiringMode.SINGLE);

    verify(mockP, times(2)).fire(1);

  }

  @Test
  public void fire_Next_On_Empty() {
    
    when(mockP.isEmpty()).thenReturn(true);
    when(mockS.isEmpty()).thenReturn(false);

    ship.fireTorpedo(FiringMode.SINGLE);

    verify(mockP, never()).fire(1);
    verify(mockS, times(1)).fire(1);

  }

  @Test
  public void fire_Fail_No_Action() {
    when(mockP.isEmpty()).thenReturn(false);
    when(mockS.isEmpty()).thenReturn(false);
    when(mockP.fire(1)).thenReturn(false);
    when(mockS.fire(1)).thenReturn(true);

    boolean result = ship.fireTorpedo(FiringMode.SINGLE);

    assertEquals(false, result);
    verify(mockP, times(1)).fire(1);
    verify(mockS, never()).fire(1);
  }

  @Test
  public void try_Firing_All() {

    when(mockP.isEmpty()).thenReturn(false);
    when(mockS.isEmpty()).thenReturn(false);

    ship.fireTorpedo(FiringMode.ALL);

    verify(mockP, times(1)).fire(1);
    verify(mockS, times(1)).fire(1);

  }

  //New test for code coverage

  @Test
  public void second_Empty_First_Fires() {

    when(mockP.isEmpty()).thenReturn(false);
    when(mockS.isEmpty()).thenReturn(true);

    ship.fireTorpedo(FiringMode.SINGLE);
    ship.fireTorpedo(FiringMode.SINGLE);

    verify(mockP, times(2)).fire(1);
    verify(mockS, never()).fire(1);

  }

}
