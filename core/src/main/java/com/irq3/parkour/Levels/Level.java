package com.irq3.parkour.Levels;

import com.irq3.parkour.Elements.Ball;
import com.irq3.parkour.Elements.Element;
import com.irq3.parkour.Managers.InputManager;

import java.util.List;

public interface Level {
   void init();
   void update();
   void getMovement(InputManager manager);
   void specialUpdate();
   void dispose();
   List<Element> addo();
   List<Element> main();
   List<Element> dello();
}
