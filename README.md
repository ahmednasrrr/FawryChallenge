# FawryChallenge - Output

## Test Case 1: Successful Checkout

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

## Test Case 2: Empty Cart

```
Error: Cart is empty
```

---

## Test Case 3: Insufficient Balance

```
Error: Customer's balance is insufficient
```

---

## Test Case 4: Out of Stock

```
Error: Insufficient stock for Cheese
```

---

## Test Case 5: Expired Product

```
Error: Expired Cheese is expired
```

---

## Test Case 6: Non-shippable Items Only

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


