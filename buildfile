repositories.remote << 'http://mirrors.ibiblio.org/pub/mirrors/maven2/'

LWJGL = transitive("org.lwjgl.lwjgl:lwjgl:jar:2.8.5")

SLICK2D = "org.slick2d:slick2d:jar:1.0.0"
download artifact(SLICK2D) => "http://www.slick2d.org/downloads/slick.jar"

mdl = Layout.new
mdl[:source, :main, :java] = 'src'
mdl[:source, :main, :resources] = 'resources'

define 'minidf', :layout => mdl do
    MAIN_CLASS = "MiniDF"

    project.version = '0.1.0'
    compile.with LWJGL, SLICK2D
    package(:jar).with :manifest => manifest.merge('Main-Class': MAIN_CLASS)

    RES_PATH = _(:source, :main, :resources)
    run.using :main => MAIN_CLASS,
              :java_args => ["-Djava.library.path=#{RES_PATH}"]
end
