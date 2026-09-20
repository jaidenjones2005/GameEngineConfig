# Game Engine Configuration Manager Journal

## Phase 1: The Eager Singleton & State Verification

**Why does checking reference equality between two variables retrieved from getInstance() confirm that you have a Singleton?**

I used two variables to call getInstance() and compared them using ==. The result was true, which confirms that both variables reference the exact same ConfigurationManager object in memory rather than two separate objects.

I also changed the volume, resolution, and fullscreen settings using the first reference. When I checked the settings using the second reference, the changes were reflected there as well. This demonstrated that both references share the same configuration state.

**How do a private constructor and static access method work together to enforce this constraint?**

The private constructor prevents other classes from directly creating a new ConfigurationManager object. The static getInstance() method provides access to the single instance without requiring another object to call it.

I used eager initialization so the instance is created when the class initializes. This ensures that the application uses the same configuration manager whenever getInstance() is called.

**Challenges:**

I had to understand the difference between creating two separate objects and creating two references to the same object. Testing reference equality and modifying settings helped me understand how the Singleton pattern works.

## Phase 2: Refactoring to Lazy Loading

**Compare eager initialization to lazy initialization. In what situations would you prefer lazy loading over eager loading, and what are the potential trade-offs of delaying object creation?**

In Phase 1, I used eager initialization, which creates the ConfigurationManager instance when the class initializes. In Phase 2, I changed the instance variable to start as null and updated getInstance() so the object is only created when it is first requested.

I would prefer lazy loading when creating an object takes a lot of resources or when the application might not need that object immediately. For example, if the configuration manager had to load settings from a file, lazy loading could avoid doing that work until the settings were actually needed.

One trade-off is that the first call to getInstance() might take longer because the object has to be created at that moment. Lazy initialization can also introduce thread-safety issues if multiple threads try to create the instance at the same time.

**Testing:**

I added a print statement inside the constructor to confirm when the instance was created. It printed only once, during the first call to getInstance(). I also confirmed that both references pointed to the same object and that changing settings through one reference affected the other.

**Challenges:**

The main challenge was understanding how the instance could start as null while still ensuring that getInstance() always returns the same object after initialization. Testing the constructor output helped me understand the difference between eager and lazy loading.

## Phase 3: Subsystem Access & Hidden Dependencies

**From the outside, can a developer or unit test tell that these classes depend on ConfigurationManager? What are hidden dependencies, and why do they make unit testing individual classes in isolation more challenging?**

In this phase, I created an AudioSystem and a GraphicsRenderer that both access the ConfigurationManager Singleton directly. Neither class requires a configuration object in its constructor, so their dependency on ConfigurationManager is not obvious just by looking at how they are created.

This is an example of a hidden dependency. The subsystems rely on the shared configuration manager internally, even though that relationship is not visible in their constructors.

Hidden dependencies can make unit testing more difficult because the subsystems automatically use the global Singleton. If one test changes a setting, another test could be affected by that shared state. It is also harder to replace the configuration manager with a mock object to test a subsystem independently.

The Singleton made it convenient to share settings without passing the configuration object around, but it also introduced tighter coupling between the subsystems and ConfigurationManager.

**Testing:**

I created both subsystems and verified that they could read the shared settings. I then changed the volume through AudioSystem and confirmed that GraphicsRenderer could immediately read the updated value. I also changed the resolution and fullscreen settings through main and verified that the renderer used those new values.

**Challenges:**

The main challenge was understanding how two separate subsystem objects could share the same configuration without receiving it through their constructors. Using getInstance() inside each subsystem helped demonstrate how the Singleton provides access to shared state.
