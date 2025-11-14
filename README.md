```
OVERVIEW - 

Saturday Sandwich Shop is a Java menu based sytem where customers can build their own
sandwiches, including Specialty Subs, choose chips and drinks, view their orders, and receive a printed receipt saved into a receipts folder.

This Project uses:
🧩Inheritance
  *ProductMain is the abstract class for the products. Any item available for purchase extends from this class. They inherit traits such as the name and price. 
🧩Interfaces
  *Pricing is an interface were any class that needs price-calculation logic can grab it. 
🧩Polymorphism
  *Order class stores a private List of Product main items. Sandwich, Drinks, and Chips are all treated the same inside a cart. 
🧩Packages
   *The classes are stores into packages to make the project easy to go through when you need to find a specific class.
  *The packages are: interfaces, models (holding all of the products information), orders, ui, and utilities.
🧩Streams & Lambdas
🧩File I/O

Running the application -
1. Open intellij
2. Run MainApplication.Java
3. The homescreen will open the whole project.
4. Navigate the menu using numbers.
5. Checkout writes a receipt and returns to the home screen.

<img width="947" height="790" alt="image" src="https://github.com/user-attachments/assets/1c5187d4-3ead-46ee-8f67-a3fb483e2da3" />


<img width="947" height="790" alt="Image" src="https://github.com/user-attachments/assets/a782eacc-4a8b-4950-888d-fb32e2e7a54f" />


