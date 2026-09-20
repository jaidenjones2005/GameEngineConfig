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
