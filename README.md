#WAZZUP

It's proof of the attacking concept on WhatsApp.

Because WhatsApp uses QR-codes and phone to log into web interface we have slitted authentication flow. 

- We open session with WhatsApp in one browser.
- We authenticate that session from another session - our smartphone.

Therefore it's quite possible to carry out so-called "The mafia fraud".

#Requirements

1) Wazzup site - fishing clone of the original site.
2) Selenium web driver to extract QR-code from the original WhatsApp
3) Profit!

I created very simple implementation of the server that proxies whatsapp auth-token(qr-code) to the wazzup site.
