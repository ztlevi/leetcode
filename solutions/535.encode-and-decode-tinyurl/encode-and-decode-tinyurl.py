import random, string
class Codec:
    def __init__(self):
        self.url2code = {}
        self.code2url = {}

    def encode(self, longUrl):
        """Encodes a URL to a shortened URL.
        
        :type longUrl: str
        :rtype: str
        """
        alphbet = string.ascii_letters + "1234567890"
        while longUrl not in self.url2code:
            code = ''.join(random.choice(alphbet) for _ in range(6))
            if code not in self.code2url:
                self.url2code[longUrl] = code
                self.code2url[code] = longUrl
        return "http://tinyrul.com/" + self.url2code[longUrl]

    def decode(self, shortUrl):
        """Decodes a shortened URL to its original URL.
        
        :type shortUrl: str
        :rtype: str
        """
        code = shortUrl.split('/')[-1]
        return self.code2url[code]
    

# Your Codec object will be instantiated and called as such:
# codec = Codec()
# codec.decode(codec.encode(url))