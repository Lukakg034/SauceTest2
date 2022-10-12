package shoppingCartCheckout;
//TODO Test
public class verifyItemTotalPriceShouldMatchSumOfAllPricesInCartPage {
}

//:2_:
//verifyItemTotalPriceShouldMatchSumOfAllPricesInCartPage (u ovom testu ubaci 3 itema u korpu, idi do predposlednje
// strane i proveri da li se suma cena 3 itema podudara sa cenom koja je data na dnu strane, pre uracunatog poreza)
//steps:
//1. otici na url
//2. ubaciti u cart tacno 3 itema cija imena prosledimo iz testa
//3. uzeti njihove cene, sacuvati negde
//4. otici do predposlednje strane order procesa
//5. sabrati prethodno sacuvane cene
//6. uporediti sa cenom koja se vidi na dnu strane "Item total:" vrednoscu
//7. asertovati da se cene poklapaju