package com.datascouting.processing.image.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import static java.lang.String.join;
import static java.util.Objects.requireNonNull;

/**
 * @author Chrisostomos Bakouras
 */
@Getter
@RequiredArgsConstructor
public class GraphicsMagickOption {

    private final String value;

    public static GraphicsMagickOption adjoin() {
        return new GraphicsMagickOption("-adjoin");
    }

    public static GraphicsMagickOption adjoin(final Boolean forceMultipleFiles) {
        requireNonNull(forceMultipleFiles);

        return new GraphicsMagickOption((forceMultipleFiles ? "+" : "-") + "adjoin");
    }

    public static GraphicsMagickOption affine(final String matrix) {
        return new GraphicsMagickOption("-affine " + matrix);
    }

    public static GraphicsMagickOption antialias() {
        return new GraphicsMagickOption("-antialias");
    }

    public static GraphicsMagickOption append() {
        return new GraphicsMagickOption("-append");
    }

    public static GraphicsMagickOption ascCdl(final String spec) {
        return new GraphicsMagickOption("-asc-cdl " + spec);
    }

    public static GraphicsMagickOption authenticate(final String password) {
        return new GraphicsMagickOption("-authenticate " + password);
    }

    public static GraphicsMagickOption autoOrient() {
        return new GraphicsMagickOption("-auto-orient");
    }

    public static GraphicsMagickOption average() {
        return new GraphicsMagickOption("-average");
    }

    public static GraphicsMagickOption backdrop() {
        return new GraphicsMagickOption("-backdrop");
    }

    public static GraphicsMagickOption background(final String color) {
        return new GraphicsMagickOption("-background \"" + color + "\"");
    }

    public static GraphicsMagickOption blackThreshold(final String red,
                                                      final String green,
                                                      final String blue,
                                                      final String opacity) {
        return new GraphicsMagickOption(
                "-background " + join(",", red, green, blue, opacity)
        );
    }

    public static GraphicsMagickOption bluePrimary(final String x,
                                                   final String y) {
        return new GraphicsMagickOption(
                "-blue-primary " + join(",", x, y)
        );
    }

    public static GraphicsMagickOption blur(final String radius) {
        return new GraphicsMagickOption("-blur " + radius);
    }

    public static GraphicsMagickOption blur(final String radius,
                                            final String sigma) {
        return new GraphicsMagickOption("-blur " + radius + 'x' + sigma);
    }

    public static GraphicsMagickOption border(final Integer width, final Integer height) {
        return new GraphicsMagickOption("-border " + width + "x" + height);
    }

    public static GraphicsMagickOption borderColor(final String color) {
        return new GraphicsMagickOption("-bordercolor " + color);
    }

    public static GraphicsMagickOption box(final String color) {
        return new GraphicsMagickOption("-box " + color);
    }

    public static GraphicsMagickOption channel(final String type) {
        return new GraphicsMagickOption("-channel " + type);
    }

    public static GraphicsMagickOption charcoal(final String factor) {
        return new GraphicsMagickOption("-charcoal " + factor);
    }

    public static GraphicsMagickOption chop(final Integer width,
                                            final Integer height,
                                            final int x,
                                            final int y) {
        return new GraphicsMagickOption(
                "-chop " +
                        width + "x" + height +
                        "+" + x + "+" + y
        );
    }

    public static GraphicsMagickOption clip() {
        return new GraphicsMagickOption("-clip");
    }

    public static GraphicsMagickOption coalesce() {
        return new GraphicsMagickOption("-coalesce");
    }

    public static GraphicsMagickOption colorize(final String value) {
        return new GraphicsMagickOption("-colorize " + value);
    }

    public static GraphicsMagickOption colors(final String value) {
        return new GraphicsMagickOption("-colors " + value);
    }

    public static GraphicsMagickOption colorspace(final String value) {
        return new GraphicsMagickOption("-colorspace " + value);
    }

    public static GraphicsMagickOption comment(final String comment) {
        return new GraphicsMagickOption("-comment " + comment);
    }

    public static GraphicsMagickOption compose(final String operator) {
        return new GraphicsMagickOption("-compose " + operator);
    }

    public static GraphicsMagickOption compress(final String type) {
        return new GraphicsMagickOption("-compress " + type);
    }

    public static GraphicsMagickOption contrast() {
        return new GraphicsMagickOption("-contrast");
    }

    public static GraphicsMagickOption convolve(final String kernel) {
        return new GraphicsMagickOption("-convolve " + kernel);
    }

    public static GraphicsMagickOption crop(final Integer width,
                                            final Integer height,
                                            final int x,
                                            final int y) {
        return new GraphicsMagickOption(
                "-crop " +
                        width + "x" + height +
                        "+" + x + "+" + y
        );
    }

    public static GraphicsMagickOption cycle(final String amount) {
        return new GraphicsMagickOption("-cycle " + amount);
    }

    public static GraphicsMagickOption debug(final String events) {
        return new GraphicsMagickOption("-debug " + events);
    }

    public static GraphicsMagickOption deconstruct() {
        return new GraphicsMagickOption("-deconstruct");
    }

    public static GraphicsMagickOption define(String key) {
        return new GraphicsMagickOption("-define " + key);
    }

    public static GraphicsMagickOption delay(String value) {
        return new GraphicsMagickOption("-delay " + value);
    }

    public static GraphicsMagickOption density(final Integer width,
                                               final Integer height) {
        return new GraphicsMagickOption("-density " + width + "x" + height);
    }

    public static GraphicsMagickOption depth(final String value) {
        return new GraphicsMagickOption("-depth " + value);
    }

    public static GraphicsMagickOption despeckle() {
        return new GraphicsMagickOption("-despeckle");
    }

    public static GraphicsMagickOption display(final String value) {
        return new GraphicsMagickOption("-display " + value);
    }

    public static GraphicsMagickOption dispose(final String method) {
        return new GraphicsMagickOption("-dispose " + method);
    }

    public static GraphicsMagickOption dither() {
        return new GraphicsMagickOption("-dither");
    }

    public static GraphicsMagickOption draw(final String value) {
        return new GraphicsMagickOption("-draw " + value);
    }

    public static GraphicsMagickOption edge(final String radius) {
        return new GraphicsMagickOption("-edge " + radius);
    }

    public static GraphicsMagickOption emboss(final String radius) {
        return new GraphicsMagickOption("-emboss " + radius);
    }

    public static GraphicsMagickOption encoding(final String type) {
        return new GraphicsMagickOption("-encoding " + type);
    }

    public static GraphicsMagickOption endian(final String type) {
        return new GraphicsMagickOption("-endian " + type);
    }

    public static GraphicsMagickOption enhance() {
        return new GraphicsMagickOption("-enhance");
    }

    public static GraphicsMagickOption equalize() {
        return new GraphicsMagickOption("-equalize");
    }

    public static GraphicsMagickOption extend(final Integer width,
                                              final Integer height,
                                              final int x,
                                              final int y) {
        return new GraphicsMagickOption(
                "-extend " +
                        width + "x" + height +
                        "+" + x + "+" + y
        );
    }

    public static GraphicsMagickOption fill(final String color) {
        return new GraphicsMagickOption("-fill " + color);
    }

    public static GraphicsMagickOption filter(final String type) {
        return new GraphicsMagickOption("-filter " + type);
    }

    public static GraphicsMagickOption flatten() {
        return new GraphicsMagickOption("-flatten");
    }

    public static GraphicsMagickOption flip() {
        return new GraphicsMagickOption("-flip");
    }

    public static GraphicsMagickOption flop() {
        return new GraphicsMagickOption("-flop");
    }

    public static GraphicsMagickOption font(final String name) {
        return new GraphicsMagickOption("-font " + name);
    }

    public static GraphicsMagickOption format(final String value) {
        return new GraphicsMagickOption("-format " + value);
    }

    public static GraphicsMagickOption frame(final Integer width,
                                             final Integer height,
                                             final Integer outerBevelWidth,
                                             final Integer innerBevelWidth) {
        return new GraphicsMagickOption(
                "-frame " +
                        width + "x" + height +
                        "+" + outerBevelWidth +
                        "+" + innerBevelWidth
        );
    }

    public static GraphicsMagickOption fuzz(final String distance) {
        return new GraphicsMagickOption("-fuzz " + distance);
    }

    public static GraphicsMagickOption gamma(final String value) {
        return new GraphicsMagickOption("-gamma " + value);
    }

    public static GraphicsMagickOption gaussian(final String radius) {
        return new GraphicsMagickOption("-gaussian " + radius);
    }

    public static GraphicsMagickOption geometry(final String geometry) {
        return new GraphicsMagickOption("-geometry " + geometry);
    }

    public static GraphicsMagickOption gravity(final String type) {
        return new GraphicsMagickOption("-gravity " + type);
    }

    public static GraphicsMagickOption greenPrimary(final int x,
                                                    final int y) {
        return new GraphicsMagickOption("-green-primary " + x + "," + y);
    }

    public static GraphicsMagickOption haldClut(final String clut) {
        return new GraphicsMagickOption("-hald-clut " + clut);
    }

    public static GraphicsMagickOption help() {
        return new GraphicsMagickOption("-help");
    }

    public static GraphicsMagickOption implode(final String factor) {
        return new GraphicsMagickOption("-implode " + factor);
    }

    public static GraphicsMagickOption intent(final String type) {
        return new GraphicsMagickOption("-intent " + type);
    }

    public static GraphicsMagickOption interlace(final String type) {
        return new GraphicsMagickOption("-interlace " + type);
    }

    public static GraphicsMagickOption label(final String name) {
        return new GraphicsMagickOption("-label " + name);
    }

    public static GraphicsMagickOption lat(final Integer width,
                                           final Integer height,
                                           final Integer offset,
                                           final Boolean percent) {
        return new GraphicsMagickOption("-lat " + width + "x" + height + "+" + offset + (percent ? "%" : ""));
    }

    public static GraphicsMagickOption level(final String blackPoint,
                                             final String gamma,
                                             final String whitePoint,
                                             final Boolean percent) {
        return new GraphicsMagickOption(
                "-level " + join(",", blackPoint, gamma, whitePoint + (percent ? "%" : ""))
        );
    }

    public static GraphicsMagickOption limit(final String type,
                                             final String value) {
        return new GraphicsMagickOption("-limit " + type + " " + value);
    }

    public static GraphicsMagickOption list(final String type) {
        return new GraphicsMagickOption("-list " + type);
    }

    public static GraphicsMagickOption log(final String value) {
        return new GraphicsMagickOption("-log " + value);
    }

    public static GraphicsMagickOption loop(final String iterations) {
        return new GraphicsMagickOption("-loop " + iterations);
    }

    public static GraphicsMagickOption magnify() {
        return new GraphicsMagickOption("-magnify");
    }

    public static GraphicsMagickOption map(final String filename) {
        return new GraphicsMagickOption("-map " + filename);
    }

    public static GraphicsMagickOption mask(final String filename) {
        return new GraphicsMagickOption("-mask " + filename);
    }

    public static GraphicsMagickOption matte() {
        return new GraphicsMagickOption("-matte");
    }

    public static GraphicsMagickOption matteColor(final String color) {
        return new GraphicsMagickOption("-mattecolor " + color);
    }

    public static GraphicsMagickOption median(final String radius) {
        return new GraphicsMagickOption("-median " + radius);
    }

    public static GraphicsMagickOption minify(final String factor) {
        return new GraphicsMagickOption("-minify " + factor);
    }

    public static GraphicsMagickOption modulate(final String value) {
        return new GraphicsMagickOption("-modulate " + value);
    }

    public static GraphicsMagickOption monitor() {
        return new GraphicsMagickOption("-monitor");
    }

    public static GraphicsMagickOption monochrome() {
        return new GraphicsMagickOption("-monochrome");
    }

    public static GraphicsMagickOption morph(final String frames) {
        return new GraphicsMagickOption("-morph " + frames);
    }

    public static GraphicsMagickOption mosaic() {
        return new GraphicsMagickOption("-mosaic");
    }

    public static GraphicsMagickOption motionBlur(final String radius) {
        return new GraphicsMagickOption("-motion-blur " + radius);
    }

    public static GraphicsMagickOption motionBlur(final String radius,
                                                  final String sigma) {
        return new GraphicsMagickOption("-motion-blur " + radius + "x" + sigma);
    }

    public static GraphicsMagickOption motionBlur(final String radius,
                                                  final String sigma,
                                                  final String angle) {
        return new GraphicsMagickOption("-motion-blur " + radius + "x" + sigma + "+" + angle);
    }

    public static GraphicsMagickOption negate() {
        return new GraphicsMagickOption("-negate");
    }

    public static GraphicsMagickOption noise(final String radius) {
        return new GraphicsMagickOption("-noise " + radius);
    }

    public static GraphicsMagickOption noop() {
        return new GraphicsMagickOption("-noop");
    }

    public static GraphicsMagickOption normalize() {
        return new GraphicsMagickOption("-normalize");
    }

    public static GraphicsMagickOption opaque(final String color) {
        return new GraphicsMagickOption("-opaque " + color);
    }

    public static GraphicsMagickOption operator(final String channel,
                                                final String operator,
                                                final String rValue,
                                                final Boolean percent) {
        return new GraphicsMagickOption(
                "-operator " +
                        join(" ", channel, operator, rValue + (percent ? "%" : ""))
        );
    }

    public static GraphicsMagickOption orderedDither(final String channelType,
                                                     final String NxN) {
        return new GraphicsMagickOption("-ordered-dither " + channelType + " " + NxN);
    }

    public static GraphicsMagickOption orient(final String orientation) {
        return new GraphicsMagickOption("-orient " + orientation);
    }

    public static GraphicsMagickOption page(final Integer width,
                                            final Integer height) {
        return new GraphicsMagickOption("-page " + width + "x" + height);
    }

    public static GraphicsMagickOption page(final Integer width,
                                            final Integer height,
                                            final String arg) {
        return new GraphicsMagickOption("-page " + width + "x" + height + arg);
    }

    public static GraphicsMagickOption paint(final String radius) {
        return new GraphicsMagickOption("-paint " + radius);
    }

    public static GraphicsMagickOption pen(final String color) {
        return new GraphicsMagickOption("-pen " + color);
    }

    public static GraphicsMagickOption ping() {
        return new GraphicsMagickOption("-ping");
    }

    public static GraphicsMagickOption pointSize(final String value) {
        return new GraphicsMagickOption("-pointsize " + value);
    }

    public static GraphicsMagickOption preview(final String type) {
        return new GraphicsMagickOption("-preview " + type);
    }

    public static GraphicsMagickOption process(final String command) {
        return new GraphicsMagickOption("-process " + command);
    }

    public static GraphicsMagickOption profile(final String filename) {
        return new GraphicsMagickOption("-profile " + filename);
    }

    public static GraphicsMagickOption quality(final String value) {
        return new GraphicsMagickOption("-quality " + value);
    }

    public static GraphicsMagickOption raise(final Integer width,
                                             final Integer height) {
        return new GraphicsMagickOption("-raise " + width + "x" + height);
    }

    public static GraphicsMagickOption randomThreshold(final String channelType,
                                                       final String LOWxHIGH) {
        return new GraphicsMagickOption(
                "-random-threshold " + channelType + " " + LOWxHIGH
        );
    }

    public static GraphicsMagickOption recolor(final String matrix) {
        return new GraphicsMagickOption("-recolor " + matrix);
    }

    public static GraphicsMagickOption redPrimary(final int x,
                                                  final int y) {
        return new GraphicsMagickOption("-red-primary " + x + "," + y);
    }

    public static GraphicsMagickOption region(final Integer width,
                                              final Integer height,
                                              final int x,
                                              final int y) {
        return new GraphicsMagickOption(
                "-region " + width + "x" + height + "+" + x + "+" + y
        );
    }

    public static GraphicsMagickOption render() {
        return new GraphicsMagickOption("-render");
    }

    public static GraphicsMagickOption rePage(final Integer width,
                                              final Integer height,
                                              final int xoff,
                                              final int yoff,
                                              final String arg) {
        return new GraphicsMagickOption("-repage " + width + 'x' + height + '+' + xoff + '+' + yoff + arg);
    }

    public static GraphicsMagickOption resample(final String horizontal,
                                                final String vertical) {
        return new GraphicsMagickOption("-resample " + horizontal + "x" + vertical);
    }

    public static GraphicsMagickOption resize(final Integer width,
                                              final Integer height) {
        return new GraphicsMagickOption("-resize " + width + "x" + height);
    }

    public static GraphicsMagickOption roll(final int x,
                                            final int y) {
        return new GraphicsMagickOption("-roll " + x + y);
    }

    public static GraphicsMagickOption rotate(final int degrees) {
        return new GraphicsMagickOption("-rotate " + degrees);
    }

    public static GraphicsMagickOption sample(final String geometry) {
        return new GraphicsMagickOption("-sample " + geometry);
    }

    public static GraphicsMagickOption samplingFactor(final String horizontalFactor,
                                                      final String verticalFactor) {
        return new GraphicsMagickOption(
                "-sampling-factor " +
                        horizontalFactor + "x" + verticalFactor
        );
    }

    public static GraphicsMagickOption scale(final String geometry) {
        return new GraphicsMagickOption("-scale " + geometry);
    }

    public static GraphicsMagickOption scene(final String value) {
        return new GraphicsMagickOption("-scene " + value);
    }

    public static GraphicsMagickOption set(final String attribute,
                                           final String value) {
        return new GraphicsMagickOption("-set " + attribute + " " + value);
    }

    public static GraphicsMagickOption unset(final String attribute) {
        return new GraphicsMagickOption("+set " + attribute);
    }

    public static GraphicsMagickOption segment(final String clusterThreshold,
                                               final String smoothingThreshold) {
        return new GraphicsMagickOption("-segment " + clusterThreshold + "x" + smoothingThreshold);
    }

    public static GraphicsMagickOption shade(final String azimuth,
                                             final String elevation) {
        return new GraphicsMagickOption("-shade " + azimuth + "x" + elevation);
    }

    public static GraphicsMagickOption sharpen(final String radius) {
        return new GraphicsMagickOption("-sharpen " + radius);
    }

    public static GraphicsMagickOption sharpen(final String radius,
                                               final String sigma) {
        return new GraphicsMagickOption("-sharpen " + radius + 'x' + sigma);
    }

    public static GraphicsMagickOption shave(final String width,
                                             final String height,
                                             final Boolean percent) {
        return new GraphicsMagickOption("-shave " + width + 'x' + height + (percent ? "%" : ""));
    }

    public static GraphicsMagickOption shear(final String xDegrees,
                                             final String yDegrees) {
        return new GraphicsMagickOption("-shear " + xDegrees + 'x' + yDegrees);
    }

    public static GraphicsMagickOption size(final Integer width,
                                            final Integer height) {
        return new GraphicsMagickOption("-size " + width + 'x' + height);
    }

    public static GraphicsMagickOption solarize(final Integer factor) {
        return new GraphicsMagickOption("-solarize " + factor);
    }

    public static GraphicsMagickOption spread(final String amount) {
        return new GraphicsMagickOption("-spread " + amount);
    }

    public static GraphicsMagickOption strip() {
        return new GraphicsMagickOption("-strip");
    }

    public static GraphicsMagickOption stroke(final String color) {
        return new GraphicsMagickOption("-stroke " + color);
    }

    public static GraphicsMagickOption strokeWidth(final String value) {
        return new GraphicsMagickOption("-strokewidth " + value);
    }

    public static GraphicsMagickOption swirl(final String degrees) {
        return new GraphicsMagickOption("-swirl " + degrees);
    }

    public static GraphicsMagickOption texture(final String filename) {
        return new GraphicsMagickOption("-texture " + filename);
    }

    public static GraphicsMagickOption threshold(final String value, final Boolean percent) {
        return new GraphicsMagickOption("-threshold " + value + (percent ? "%" : ""));
    }

    public static GraphicsMagickOption thumbnail(final Integer width,
                                                 final Integer height) {
        return new GraphicsMagickOption("-thumbnail " + width + "x" + height);
    }

    public static GraphicsMagickOption tile(final String filename) {
        return new GraphicsMagickOption("-tile " + filename);
    }

    public static GraphicsMagickOption transform() {
        return new GraphicsMagickOption("-transform");
    }

    public static GraphicsMagickOption transparent(final String color) {
        return new GraphicsMagickOption("-transform " + color);
    }

    public static GraphicsMagickOption treeDepth(final String value) {
        return new GraphicsMagickOption("-treedepth " + value);
    }

    public static GraphicsMagickOption trim() {
        return new GraphicsMagickOption("-trim");
    }

    public static GraphicsMagickOption type(final String type) {
        return new GraphicsMagickOption("-type " + type);
    }

    public static GraphicsMagickOption units(final String type) {
        return new GraphicsMagickOption("-units " + type);
    }

    public static GraphicsMagickOption unSharp(final String radius) {
        return new GraphicsMagickOption("-unsharp " + radius);
    }

    public static GraphicsMagickOption unSharp(final String radius,
                                               final String sigma) {
        return new GraphicsMagickOption("-unsharp " + radius + "x" + sigma);
    }

    public static GraphicsMagickOption unSharp(final String radius,
                                               final String sigma,
                                               final String amount) {
        return new GraphicsMagickOption(
                "-unsharp " + radius + "x" + sigma + "+" + amount
        );
    }

    public static GraphicsMagickOption unSharp(final String radius,
                                               final String sigma,
                                               final String amount,
                                               final String threshold) {
        return new GraphicsMagickOption(
                "-unsharp " + radius + "x" + sigma + "+" + amount + "+" + threshold
        );
    }

    public static GraphicsMagickOption usePixmap() {
        return new GraphicsMagickOption("-use-pixmap");
    }

    public static GraphicsMagickOption verbose() {
        return new GraphicsMagickOption("-verbose");
    }

    public static GraphicsMagickOption version() {
        return new GraphicsMagickOption("-version");
    }

    public static GraphicsMagickOption view(final String value) {
        return new GraphicsMagickOption("-view " + value);
    }

    public static GraphicsMagickOption virtualPixel(final String method) {
        return new GraphicsMagickOption("-virtual-pixel " + method);
    }

    public static GraphicsMagickOption wave(final String amplitude,
                                            final String waveLength) {
        return new GraphicsMagickOption("-wave " + amplitude + "x" + waveLength);
    }

    public static GraphicsMagickOption whitePoint(final int x,
                                                  final int y) {
        return new GraphicsMagickOption("-white-point " + x + "," + y);
    }

    public static GraphicsMagickOption whiteThreshold(final String red,
                                                      final String green,
                                                      final String blue,
                                                      final String opacity) {
        return new GraphicsMagickOption(
                "-white-threshold " + join(",", red, green, blue, opacity)
        );
    }

    public static GraphicsMagickOption write(final String filename) {
        return new GraphicsMagickOption("-write " + filename);
    }
}
