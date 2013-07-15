## vermont
experimental library for upgrading version

## motivation
upgrading versions is really hard, but also really super useful, in case you ever want to change
to a more useful form of data, for example in serialization.  this library experiments with
different apis for upgrading versions

## apis
Versions can be seen as vertices, and the upgrades as edges.  Using this, you can make a graph of
version upgrading.  However, the typing doesn't really seem to work out.  I'm not sure that it's
possible to make the typing very clean, but I'm going to try to work it out.
