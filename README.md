<h1>TakeOutSimulator 🍔</h1>
<p>Ett enkelt Java-projekt som simulerar ett takeout-system där användare kan beställa mat, lägga till valda rätter i sin kasse och checka ut när de är redo eller när de inte har tillräckligt med pengar kvar.</p>

<h2>Funktioner</h2>
<ul>
  <li>Menyval: Användaren kan välja rätter från en meny och se kostnaden för varje rätt.</li>
  <li>ShoppingBag: Simulerar en "shopping bag" där användaren kan lägga till rätter och se totalbeloppet.</li>
  <li>Kundbalans: Håller reda på användarens pengar och ser till att de bara kan köpa rätter de har råd med.</li>
  <li>Utcheckning: Användaren kan när som helst checka ut för att se sin återstående balans och få ett meddelande att njuta av maten.</li>
</ul>

<h2>Struktur</h2>
<ul>
  <li>Customer: Hanterar kundens namn och saldo.</li>
  <li>FoodMenu: Skapar en meny med tillgängliga maträtter.</li>
  <li>ShoppingBag: Spårar de valda rätterna och deras totala kostnad.</li>
  <li>TakeOutSimulator: Huvudlogiken för beställningsflödet, interaktion med användaren och utcheckning.</li>
</ul>
