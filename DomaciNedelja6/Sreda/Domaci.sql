-- Izvuci sve za profesore starije od 45 godina (Resenje: 1 i 3)

SELECT * FROM profesori
WHERE godine > 45;

-- Izvuci imena i prezimena svih ucenika koji su stariji od 15 godina i ciji je prosek preko 6.5 (Resenje: 1 i 3)

SELECT ime, prezime FROM ucenici
WHERE godine > 15 AND prosek > 6.5;

-- Izvuci godine svih ucenika sortirane opadajuce (Resenje: 24, 23, 23, 15, 12, 10)

SELECT godine FROM ucenici 
ORDER BY godine DESC;

-- Izvuci sve za profesore koji predaju 'Informatiku' (Resenje: )

SELECT * FROM profesori
WHERE predmet = 'Informatika';

-- Izvuci id, imena i prezimena svih ucenika cije ime sadrzi tacno 6 slova (Resenje: Cvijan i Milena)

SELECT ucenikid, ime, prezime FROM ucenici
WHERE LENGTH(ime) = 6;
