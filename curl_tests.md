
## Register 
curl -X POST \
  https://cst438-project02-c9c0086736bb.herokuapp.com/api/auth/register \
  -H "Content-Type: application/json" \
  -d '{"email":"test@test.com","username":"testuser1","password":"password123"}'


## Login 
curl -X POST \
  https://cst438-project02-c9c0086736bb.herokuapp.com/api/auth/login \
  -H "Content-Type: application/json" \
  -d '{"email":"test@test.com","password":"password123"}'





# userId 4
curl -X POST \
  https://cst438-project02-c9c0086736bb.herokuapp.com/api/progress \
  -H "Content-Type: application/json" \
  -d '{"userId": 4, "date": "2025-10-30", "weight": 189.0, "bfPercentage": 14.3}'

# userId 5
curl -X POST \
  https://cst438-project02-c9c0086736bb.herokuapp.com/api/progress \
  -H "Content-Type: application/json" \
  -d '{"userId": 5, "date": "2025-10-30", "weight": 266.1, "bfPercentage": 28.0}'

# userId 6
curl -X POST \
  https://cst438-project02-c9c0086736bb.herokuapp.com/api/progress \
  -H "Content-Type: application/json" \
  -d '{"userId": 6, "date": "2025-10-30", "weight": 170.2, "bfPercentage": 19.2}'

# userId 7
curl -X POST \
  https://cst438-project02-c9c0086736bb.herokuapp.com/api/progress \
  -H "Content-Type: application/json" \
  -d '{"userId": 7, "date": "2025-10-30", "weight": 186.0, "bfPercentage": 9.8}'

# userId 8
curl -X POST \
  https://cst438-project02-c9c0086736bb.herokuapp.com/api/progress \
  -H "Content-Type: application/json" \
  -d '{"userId": 8, "date": "2025-10-30", "weight": 162.0, "bfPercentage": 16.2}'




curl -X GET https://cst438-project02-c9c0086736bb.herokuapp.com/api/progress/user/4
curl -X GET https://cst438-project02-c9c0086736bb.herokuapp.com/api/progress/user/5
curl -X GET https://cst438-project02-c9c0086736bb.herokuapp.com/api/progress/user/6
curl -X GET https://cst438-project02-c9c0086736bb.herokuapp.com/api/progress/user/7
curl -X GET https://cst438-project02-c9c0086736bb.herokuapp.com/api/progress/user/8


