# FawryChallenge - Output

## test case 1: successful checkout

```
** Shipment notice **
1x Cheese 500.0g
1x Cheese 500.0g
1x Biscuits 700.0g
1x Mobile 300.0g
Total package weight 2.0kg

** Checkout receipt **
2x Cheese 200
1x Biscuits 50
1x Scratch Card 100
1x Mobile 15000
--------------------------
Subtotal 15350
Shipping 60
Amount 15410
Customer balance after payment: 4590.0
END.
```

---

## test case 2: empty Cart

```
Error: Cart is empty
```

---

## test case 3: insufficient balance

```
Error: Customer's balance is insufficient
```

---

## test case 4: out of stock

```
Error: Insufficient stock for Cheese
```

---

## test case 5: expired product

```
Error: Expired Cheese is expired
```

---

## test case 6: non-shippable items only

```
** Checkout receipt **
3x Scratch Card 300
--------------------------
Subtotal 300
Shipping 0
Amount 300
Customer balance after payment: 4700.0
END.
```

---

### Process finished with exit code 0

---


