# UrlShortener
Simple URL shortener microservice using Spring Boot

## Flow
![Api Flow](https://user-images.githubusercontent.com/36466228/111921675-907eca80-8a74-11eb-9162-f268206503c4.png)

## The logic behind this URL Shortener
Whenever the URL Shortener receives a link to shorten, it will save a new entry in the database containing the original URL and a new, short, URL. Along with some other informations, like the date when the link was created.

When a short URL is provided to the shortener, it will look for the original link in the database and provide it. Also, it will update the statistics of the given URL, increasing the number of visits received.

Another function available in this Url Shortener is to view the statistics behind a generated URL. When using this functionality, data such as total number of visits, date of creation and the mean of visits per day will be returned to the user.

### How do we create a short URL?
As we want to take a given long URL and transform it in a smaller one, we'll use a hashing algorithm, such as CRC32 to transform it. The problem with using just this approach is: if the same long URL was provided different times, it would always result in the same short link. So, to overcome this problem, when generating the hash, we also pass the current date and time to the hashing algorithm and it solves the issue.

## Demonstration
This project was deployed to heroku and is available on the following URL: https://url-shortener-phnc.herokuapp.com/

Please, feel free to try it out using Postman, Insomnia or any tool of your preference!

Below is the demonstration of a request made using Postman:

![image](https://user-images.githubusercontent.com/36466228/113743767-6c5cf380-96da-11eb-9fde-44e2fc21f5b5.png)

Using the shortURL returned, it is possible to access the original webpage as in the example below:

![image](https://user-images.githubusercontent.com/36466228/113744681-4d129600-96db-11eb-9841-7cb0b37b683a.png)

It is also possible to visualize some statistics about the shortURL created as in the next example:

![image](https://user-images.githubusercontent.com/36466228/113745494-b85c6800-96db-11eb-94cc-e1ed6765401b.png)
