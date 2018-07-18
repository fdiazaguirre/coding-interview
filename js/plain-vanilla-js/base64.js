let Base64 = {};

Base64.prototype.encode = (str) => {
  // Defaults to utf8
  return Buffer.from(str).toString('Base64');
}

Base64.prototype.decode = (b64string) => {
  return Buffer.from(b64string, 'base64');;
}