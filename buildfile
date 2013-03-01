repositories.remote << 'http://mirrors.ibiblio.org/pub/mirrors/maven2/'

LWJGL = transitive("org.lwjgl.lwjgl:lwjgl:jar:2.8.5")

ALL_LWJGL_NATIVES = {
    osx: "org.lwjgl.lwjgl:lwjgl-platform:jar:natives-osx:2.8.5",
    windows: "org.lwjgl.lwjgl:lwjgl-platform:jar:natives-windows:2.8.5",
    linux: "org.lwjgl.lwjgl:lwjgl-platform:jar:natives-linux:2.8.5",
}

NATIVE_AF=""
if (/darwin/ =~ RUBY_PLATFORM) != nil
    NATIVE_AF=ALL_LWJGL_NATIVES[:osx]
end
if (/linux/ =~ RUBY_PLATFORM) != nil
    NATIVE_AF=ALL_LWJGL_NATIVES[:linux]
end

LWJGL_NATIVE = artifact(NATIVE_AF)
LWJGL_NATIVE.invoke

SLICK2D = "org.slick2d:slick2d:jar:1.0.0"
download artifact(SLICK2D) => "http://www.slick2d.org/downloads/slick.jar"

mdl = Layout.new
mdl[:source, :main, :java] = 'src'
mdl[:source, :main, :resources] = 'resources'

define 'minidf', :layout => mdl do
    project.version = '0.1.0'
    compile.with LWJGL, SLICK2D
    package :jar

    # Extract to resources
    RES_PATH = _(:source, :main, :resources)
    #build do
    #    system "unzip #{LWJGL_NATIVE} -d #{RES_PATH}"
    #end

    run.using :main => "MiniDF",
              :java_args => ["-Djava.library.path=#{RES_PATH}"]
end
