## JSON DIFF UTIL


**A Tiny Json To Json Differentiator **

Useful for :
  1. Json Keys Diff (Missing,Matching,Extra keys)
  2. Json value Diff (Not Matching and matching values
  3. Also supports ignoring specific keys.


Example : 
```java
JSON1 = {
  "Rating": 1,
  "SecondaryRatings": {
    "Design": 4,
    "Price": 2,
    "RatingDimension3": 1
  }
}

JSON2 = {
  "Rating1": 1,
  "SecondaryRatings": {
    "Design": 1,
    "Price": 2,
    "RatingDimension3": 2
  }
}

DiffResponse 
-----------------------------------------------------------------------------------
JsonDiff: {
  missingKeys: [
    Rating1
  ],
  unexpectedKeys: [
    
  ],
  matchingValues: {
    SecondaryRatings.Price: 2,
    SecondaryRatings.RatingDimension3: 2
  },
  notMatchingValues: {
    SecondaryRatings.Design=(4,
    1)
  }
}
------------------------------------------------------------------------------------
```
## Author

👤 **Ayush Vipul**

- Github: [@ayush-vipul](https://github.com/ayush-vipul)
  
   
   
  
## 📝 License

Copyright © 2020 [Ayush Vipul](https://github.com/ayush-vipul).<br />

