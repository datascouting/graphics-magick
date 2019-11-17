# graphics-magick

graphics-magick is a java wrapper for GraphicsMagick's a powerful command line utility gm, which may be used to access all GraphicsMagick functions.

## Getting Started

These instructions will guide you on how to use this library.

### Prerequisites

* Install [GraphicsMagic](http://www.graphicsmagick.org/download.html)
* GraphicsMagic not natively supports some formats. Refer to this [list](http://www.graphicsmagick.org/formats.html). In order to support more formats you must install the required software.

### Installing

Add the dependency into your pom.xml

```
<dependency>
    <groupId>com.datascouting.processing.image</groupId>
    <artifactId>graphics-magick</artifactId>
    <version>1</version>
</dependency>
```

## How to use

You must initialize the GraphicsMagick object.

```
final GraphicsMagick gm = new GraphicsMagick();
```
Or
```
final Path binary = Paths.get("/usr/bin/gm");
final GraphicsMagick gm = new GraphicsMagick(binary);
```

Note that the empty constructor will use the default installation path of GraphicsMagick in linux (/usr/bin/gm).
If you wish to use another binary please use the path constructor with the proper binary. `e.g. C:\Program Files\GraphicsMagick\gm.exe` 

After initialization you can use GraphicsMagick sub-commands. 

Note that currently only convert sub-command is supported.

## Convert sub-command
```
gm.convert(
   List.of(
      GraphicsMagickOption.size(200, 200),
      ......
   ),
   inputFile,
   List.of( ..... ),
   outputFile
)
```

`GraphicsMagickOption` contains all options provided by GraphicsMagick, please refer [GraphicsMagick documentation](http://www.graphicsmagick.org/convert.html).

Convert sub-command Parameters: 
* `inputOptions: List<GraphicsMagickOption>` - Options are processed in order. Any option you specify remains in effect for the set of images that follows.
* `inputFile: File` - This file is the source/original file that will be converted.
* `outputOptions: List<GraphicsMagickOption>` - Options are processed in order. Any option you specify remains in effect for the set of images that follows.
* `outputFile: File` - This file is the result of the conversion.

## Contributing

Please read [CONTRIBUTING.md](https://gist.github.com/PurpleBooth/b24679402957c63ec426) for details on our code of conduct, and the process for submitting pull requests to us.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details
