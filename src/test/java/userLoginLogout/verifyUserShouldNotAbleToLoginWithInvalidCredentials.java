package userLoginLogout;
//TODO Test
public class verifyUserShouldNotAbleToLoginWithInvalidCredentials {
}

//:1_:  verifyUserShouldNotAbleToLoginWithInvalidCredentials (ovaj test se razlikuje od
// onog TC sto imas vec jer u onom testu ti koristis LOCKED_USER kredencijale). u ovom testu namerno posalji
// pogresni kredencijal neki i proveri da li se vidi error poruka
//steps:
//1. otici na url
//2. uneti pogresne rezultate za standard_user nalog
//3. asertovati da login nije uspeo